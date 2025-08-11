package com.ashu.blogapp.users.dtos;

import lombok.*;

@Data
@Setter(AccessLevel.NONE)


public class CreateUserRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;
}
