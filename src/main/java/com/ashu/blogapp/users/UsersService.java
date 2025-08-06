 package com.ashu.blogapp.users;

import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    UsersService(UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }

    public UserEntity createUser (String username,String password,String email){
        var user=UserEntity.builder().username(username).email(email).build()/*password(password)*/;

        return usersRepository.save(user);
    }

    public UserEntity getUser(String username){
        return usersRepository.findByUsername(username);
    }

    public UserEntity loginUser(String username,String password){
        var user=usersRepository.findByUsername(username);

        if(user==null){
            throw new UserNotFoundException(username);
        }
        //TODO:match password
        return  user;
    }

    static class UserNotFoundException extends IllegalArgumentException{
        public UserNotFoundException(String username){
            super("User "+username+" not found.");
        }
    }
}
