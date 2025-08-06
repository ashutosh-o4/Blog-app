package com.ashu.blogapp.users;

import com.ashu.blogapp.users.dtos.CreateUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UsersServiceTests {

    @Autowired
    UsersService usersService;
    @Test
    void can_create_users(){
         var user=usersService.createUser(new CreateUserRequest(
                "Ashu",
                "Ashu2004",
                "ashutosh@mail.com"));

        Assertions.assertNotNull(user);
        Assertions.assertEquals("Ashu",user.getUsername());

    }
}
