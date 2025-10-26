package com.example.microservices.controller;

import com.example.microservices.exception.ResourceNotFound;
import com.example.microservices.model.User;
import com.example.microservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity <List<User>> getUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity <User> getUsers(@PathVariable Long id ){
        return ResponseEntity.ok(userRepository.findById(id).orElseThrow(()->new ResourceNotFound("User Not Found with id :"+id)));
    }

    @PostMapping("/create")
    public ResponseEntity <User> userCreate(@RequestBody User user){
        return ResponseEntity.ok(userRepository.save(user));
    }



}
