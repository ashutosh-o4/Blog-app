package com.ashu.blogapp.users;

import com.ashu.blogapp.users.dtos.CreateUserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
@ActiveProfiles("test")
public class UsersServiceTests {

    @Autowired UsersService usersService;

    @Test
    void can_create_user(){
        var user=usersService.createUser(new CreateUserRequest("john","john123","john@123"));

        Assertions.assertNotNull(user);
        Assertions.assertEquals("john",user.getUsername());
    }
}
