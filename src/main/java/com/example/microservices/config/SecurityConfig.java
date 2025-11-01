package com.example.microservices.config;

import com.example.microservices.service.CustomUserServiceDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http

                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/h2-console").permitAll()
                        .anyRequest().authenticated())

                .httpBasic(Customizer.withDefaults());
//                .anyRequest("/h2-console/**").permitAll() ;// Allow access to H2 console
//                .anyRequest().authenticated()
//                .and()
//                .csrf()
//                .ignoringAntMatchers("/h2-console/**") // Disable CSRF for H2 console
//                .and()
//                .headers()
//                .frameOptions().sameOrigin(); // Allow H2 console to load in a frame

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserServiceDetails();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder){

        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(daoAuthenticationProvider);
    }

}
