package com.example.microservices.filter;

import jakarta.servlet.*;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LogggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServlet= (HttpServletRequest) servletRequest;
        System.out.println("Logging filter URL "+httpServlet.getRequestURL());

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
