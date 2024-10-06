package com.avs.spring_security_example_3.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avs.spring_security_example_3.model.Student;

import jakarta.servlet.http.HttpServletRequest;


@RestController
public class StudentController {

    private List<Student> students = Arrays.asList(
        new Student(1, "Alice"),
        new Student(2, "Bob"),
        new Student(3, "Charlie")
    );


    @GetMapping("/students")
    public List<Student> getAllstudents() {
        return students;
    }
    
    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest req) {
        return (CsrfToken) req.getAttribute("_csrf");
    }
}

