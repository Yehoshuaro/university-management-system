package com.example.coursemanagementsystem.repositories;
import com.example.coursemanagementsystem.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
