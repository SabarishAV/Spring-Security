package com.avs.spring_security_example_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avs.spring_security_example_3.model.Users;
import com.avs.spring_security_example_3.service.UserService;

@RestController
@RequestMapping("/user")
public class UserContoller {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users user){
        return service.registerUser(user);
    }
    
}
