 package com.ashu.blogapp.users;

import com.ashu.blogapp.users.dtos.CreateUserRequest;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UsersService(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    public UserEntity createUser (CreateUserRequest req){
        UserEntity newUser=modelMapper.map(req,UserEntity.class);
        //TODO: encrypt and save password as well

        return usersRepository.save(newUser);
    }

    public UserEntity getUser(String username){
        return usersRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
    }

    public UserEntity getUser(Long userId){
        return usersRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
    }

    public UserEntity loginUser(String username,String password){
        return usersRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
        //TODO:match password
    }

    public static class UserNotFoundException extends IllegalArgumentException{
        public UserNotFoundException(String username){
            super("User with username:"+username+" not found.");
        }
        public UserNotFoundException(Long Id){
            super("User with id:"+Id+" not found.");
        }
    }
}
