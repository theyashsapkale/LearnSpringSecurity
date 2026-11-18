package com.example.securityLearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class UserController {

@Autowired
private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @GetMapping()
    public String  hello(){
        System.out.println(passwordEncoder.encode("yash1234"));
        System.out.println(passwordEncoder.encode("nikhil123"));

        return "Hello";
    }

}
