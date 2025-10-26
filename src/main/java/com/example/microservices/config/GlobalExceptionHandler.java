package com.example.microservices.config;

import com.example.microservices.exception.ResourceNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String>resourceNotFoundException(ResourceNotFound ex){
        return ResponseEntity.ok("Resource Not Found");
    }
}
