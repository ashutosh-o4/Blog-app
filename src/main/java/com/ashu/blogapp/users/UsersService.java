 package com.ashu.blogapp.users;

import com.ashu.blogapp.users.dtos.CreateUserRequest;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    UsersService(UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }

    public UserEntity createUser (CreateUserRequest req){
        var user=UserEntity.builder().username(req.getUsername())
                .email(req.getEmail())
                .build()/*password(password)*/;

        return usersRepository.save(user);
    }

    public UserEntity getUser(String username){
        return usersRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
    }

    public UserEntity getUser(Long userId){
        return usersRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
    }

    public UserEntity loginUser(String username,String password){
        var user=usersRepository.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
        //TODO:match password
        return  user;
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
