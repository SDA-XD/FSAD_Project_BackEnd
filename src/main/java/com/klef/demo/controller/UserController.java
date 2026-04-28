package com.klef.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.demo.entity.User;
import com.klef.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "https://aidlink-app.netlify.app/")
public class UserController {

    @Autowired
    private UserService userService;

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    // GET ALL USERS (Admin)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
 // TOTAL USERS
    @GetMapping("/count")
    public long getTotalUsers() {
        return userService.getTotalUsers();
    }

    // COUNT BY ROLE
    @GetMapping("/count/{role}")
    public long getCountByRole(@PathVariable String role) {
        return userService.getUserCountByRole(role);
    }
}