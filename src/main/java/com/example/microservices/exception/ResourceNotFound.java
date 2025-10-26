package com.example.microservices.exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(String msg){
        super(msg);
    }
}
