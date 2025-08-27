package com.ashu.blogapp.security;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JWTSecurityTests {

    JWTService jwtService=new JWTService() ;

    @Test
    void canCreateJWTFromUserId() {
        var jwt=jwtService.createJwt(1001L);
        assertNotNull(jwt);
    }
}
