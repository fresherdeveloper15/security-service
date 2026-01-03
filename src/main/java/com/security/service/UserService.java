package com.security.service;

import com.security.dtos.LoginRequest;
import com.security.dtos.RegisterRequest;
import com.security.entities.User;
import com.security.respository.UserRepository;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
   // private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // REGISTER
    public User register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        // HASH password
       // user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }

    // LOGIN
    public boolean login(LoginRequest request) {
        // Find user by username (or email)
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Compare password
        return (request.getPassword().equalsIgnoreCase(user.getPassword()));
        //return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}

