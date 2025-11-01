package com.example.microservices.util;

import com.example.microservices.dto.AuthRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTutil {

    private final long EXPIRATION_TIME=60*60*1000;
    private final String SECRET_KEY="my-super-secret-key-that-is-long-enough-1234567890!@#";
    private final SecretKey key= Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    public String generateToken(AuthRequest authRequest){

        return Jwts.builder()
                .setSubject(authRequest.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
        .compact();


    }

}
