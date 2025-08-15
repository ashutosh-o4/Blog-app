package com.ashu.blogapp.users;

import com.ashu.blogapp.users.dtos.CreateUserRequest;
import com.ashu.blogapp.users.dtos.UserResponse;
import com.ashu.blogapp.users.dtos.LoginUserRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ashu.blogapp.common.dtos.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;
    private final ModelMapper modelMapper;

    public UsersController(UsersService usersService, ModelMapper modelMapper) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    ResponseEntity<UserResponse> signupUser(@RequestBody CreateUserRequest request){
        UserEntity savedUser=usersService.createUser(request);
        URI savedUserUri = URI.create("/users/"+savedUser.getId());

        return ResponseEntity.created(savedUserUri)
                .body(modelMapper.map(savedUser, UserResponse.class));
    }

    @PostMapping("/login")
    ResponseEntity <UserResponse> loginUser(@RequestBody LoginUserRequest request){
        UserEntity savedUser=usersService.loginUser(request.getUsername(),request.getPassword());
        return ResponseEntity.ok(modelMapper.map(savedUser, UserResponse.class));
    }

    @ExceptionHandler({
            UsersService.UserNotFoundException.class
    })
    ResponseEntity <ErrorResponse> handleUserNotFoundException(Exception ex){

        String msg;
        HttpStatus status;
        if(ex instanceof UsersService.UserNotFoundException){
            msg=ex.getMessage();
            status=HttpStatus.NOT_FOUND;
        } else{
            status=HttpStatus.INTERNAL_SERVER_ERROR;
            msg="Something went wrong";
        }
        ErrorResponse internalServerError= ErrorResponse.builder().message(msg).build();

        return ResponseEntity.status(status).body(internalServerError);
    }

}

