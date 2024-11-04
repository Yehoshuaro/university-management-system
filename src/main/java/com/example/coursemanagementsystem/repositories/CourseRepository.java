package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}