 package com.ashu.blogapp.users;

import com.ashu.blogapp.users.dtos.CreateUserRequest;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity createUser (CreateUserRequest req){
        UserEntity newUser=modelMapper.map(req,UserEntity.class);
        newUser.setPassword(passwordEncoder.encode(req.getPassword()));

        return usersRepository.save(newUser);
    }

    public UserEntity getUser(String username){
        return usersRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
    }

    public UserEntity getUser(Long userId){
        return usersRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
    }

    public UserEntity loginUser(String username,String password){
        var user=usersRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
        var passwordMatch= passwordEncoder.matches(password,user.getPassword());
        if(!passwordMatch) throw new InvalidCredentialsException();
        return user;
    }

    public static class UserNotFoundException extends IllegalArgumentException{
        public UserNotFoundException(String username){
            super("User with username:"+username+" not found.");
        }
        public UserNotFoundException(Long Id){
            super("User with id:"+Id+" not found.");
        }
    }

    public static class InvalidCredentialsException extends IllegalArgumentException{
        public InvalidCredentialsException(){
            super("Invalid Username or password combination.");
        }
    }
}
