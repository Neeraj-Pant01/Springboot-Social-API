package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authservice;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginrequest){
        return authservice.login(loginrequest.getemail(), loginrequest.getPassword());
    }

    @PostMapping("/register")
    public User Register(@RequestBody User user){
        return authservice.register(user);
    }
}
