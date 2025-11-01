package com.example.microservices.service;

import com.example.microservices.model.User;
import com.example.microservices.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminUserInitiliser {

    @Bean
    public CommandLineRunner createAdminUser(UserRepository userRepository, PasswordEncoder passwordEncoder){

        return args -> {
            if(userRepository.findByName("admin").isEmpty()){
                User user=new User();
                user.setName("admin");
                user.setPassword(passwordEncoder.encode("123"));

                user.setEmail("admin@springboot.com");
                user.setRole("ROLE_ADMIN");

                userRepository.save(user);
                System.out.println("Default user created!!!");
            }

        };

    }
}
