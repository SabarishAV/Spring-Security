package com.avs.spring_security_example_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class HelloController {
    
    @GetMapping("/")
    public String greet() {
        return "Welcome to my page";
    }

    @GetMapping("/sessionId")
    public String getMethodName(HttpServletRequest request) {
        return "Session Id: " + request.getSession().getId();
    }
    
}
