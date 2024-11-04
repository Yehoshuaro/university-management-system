package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}