package com.example.microservices.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private final LoggerInterceptor loggerInterceptor;

    public WebConfig(LoggerInterceptor loggerInterceptor) {
        this.loggerInterceptor = loggerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loggerInterceptor)
                .addPathPatterns("/api/users/**")
                .excludePathPatterns("/api/users/auth/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
