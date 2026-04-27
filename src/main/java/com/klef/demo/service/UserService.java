package com.klef.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.demo.entity.User;
import com.klef.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CREATE (Register)
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // READ (Get all users - Admin)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // LOGIN
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
 // TOTAL USERS
    public long getTotalUsers() {
        return userRepository.count();
    }

    // COUNT BY ROLE
    public long getUserCountByRole(String role) {
        return userRepository.countByRole(role);
    }
}