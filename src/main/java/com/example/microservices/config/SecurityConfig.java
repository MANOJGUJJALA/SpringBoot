package com.example.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
//                .anyRequest("/h2-console/**").permitAll() // Allow access to H2 console
//                .anyRequest().authenticated()
//                .and()
//                .csrf()
//                .ignoringAntMatchers("/h2-console/**") // Disable CSRF for H2 console
//                .and()
//                .headers()
//                .frameOptions().sameOrigin(); // Allow H2 console to load in a frame

        return http.build();
    }

}
