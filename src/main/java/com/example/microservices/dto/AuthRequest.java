package com.example.microservices.dto;


import lombok.Data;

@Data
public class AuthRequest {

    private String name;
    private String password;
}
