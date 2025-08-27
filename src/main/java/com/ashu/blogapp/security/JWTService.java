package com.ashu.blogapp.security;

import com.auth0.jwt.JWT;
import java.util.Date;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

@Service
public class JWTService {
    //TODO:move the key to a separate .properties file(not in git).
    private static final String JWT_KEY="djpq2938ruqcn98eur9202c9nu";
    private final Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);

    public String createJwt(Long userId){
        return JWT.create()
                .withSubject(userId.toString())
                .withIssuedAt(new Date())
                //.withExpiresAt(new Date()) TODO:setup expiry parameter
                .sign(algorithm);
    }

    public Long retrieveUserId(String jwtString){
        var decodedJwt = JWT.decode(jwtString);
        return Long.valueOf(decodedJwt.getSubject());
    }
}
