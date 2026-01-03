package com.security.controller;

import com.security.dtos.LoginRequest;
import com.security.dtos.RegisterRequest;
import com.security.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // REGISTER
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        userService.register(request);
        return "User registered successfully";
    }

    // LOGIN
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        boolean success = userService.login(request);
        return success ? "Login successful" : "Invalid credentials";
    }

    @GetMapping("/login")
    public void login() {

    }
}

