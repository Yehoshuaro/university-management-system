package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.entities.User; // Entity class representing User
import org.springframework.data.jpa.repository.JpaRepository; // Spring Data JPA repository interface

import java.util.Optional;

// Repository interface for User entity, extending JpaRepository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Method to find a User by their email, returns an Optional<User>
    Optional<User> findByEmail(String email);
}