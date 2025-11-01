package com.example.microservices.controller;

import com.example.microservices.dto.AuthRequest;
import com.example.microservices.util.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTutil jwTutil;

    @PostMapping("/auth")
    public String  generateToken(@RequestBody AuthRequest authRequest){

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken( authRequest.getName(),authRequest.getPassword()));

           return jwTutil.generateToken(authRequest);
        }
        catch (Exception e){
            throw  e;
        }


    }
}
