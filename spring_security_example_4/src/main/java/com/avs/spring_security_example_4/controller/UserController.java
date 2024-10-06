package com.avs.spring_security_example_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avs.spring_security_example_4.model.Users;
import com.avs.spring_security_example_4.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register/") // always remember to put the trailing slash(/) at the end of the api
    public Users register(@RequestBody Users user){
        return service.registerUser(user);
    }

    @PostMapping("/login/")
    public String login(@RequestBody Users user){
        return service.verify(user);
    }
    
}
