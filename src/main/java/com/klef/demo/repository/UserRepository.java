package com.klef.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    long countByRole(String role); // ✅
}