package com.avs.spring_security_example_5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @GetMapping("/greet/")
    public String greet(){
        return "Welcome to my page";
    }
    
}
