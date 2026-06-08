package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        return "Application is working";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserDto userDto) {

        User user = new User();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userService.registerUser(user);

        if (savedUser == null) {
            return "Email already registered";
        }

        return "Registration successful";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDto loginDto) {

        User user = userService.loginUser(
                loginDto.getEmail(),
                loginDto.getPassword());

        if (user == null) {
            return "Invalid Credentials";
        }

        return "Login Successful";
    }
}