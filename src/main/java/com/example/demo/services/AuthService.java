package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtutil;
    @Autowired
    private UserRepository userrepository;
    @Autowired
    private PasswordEncoder passwordencoder;

    public String login(String email , String password){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email , password)
        );
        return jwtutil.generateToken(email);
    }

    public User register(User user){
        user.setPassword(passwordencoder.encode(user.getPassword()));
        return userrepository.save(user);
    }
}
