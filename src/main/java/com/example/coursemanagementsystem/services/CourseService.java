package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.dto.CourseDTO; // Data Transfer Object for Course
import com.example.coursemanagementsystem.entities.Course; // Entity class representing Course
import com.example.coursemanagementsystem.repositories.CourseRepository; // Repository interface for Course
import com.example.coursemanagementsystem.services.factory.CourseFactory; // Factory for Course and CourseDTO creation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Indicates that this class is a service component
public class CourseService {

    @Autowired
    private CourseRepository courseRepository; // Injects the CourseRepository

    // Saves a new course and returns the corresponding CourseDTO
    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = CourseFactory.createCourse(courseDTO); // Converts DTO to entity
        return CourseFactory.createCourseDTO(courseRepository.save(course)); // Saves and converts back to DTO
    }

    // Retrieves a course by its ID and returns the corresponding CourseDTO
    public CourseDTO getCourseById(Long id) {
        return courseRepository.findById(id) // Finds the course by ID
                .map(CourseFactory::createCourseDTO) // Converts to DTO if present
                .orElse(null); // Returns null if not found
    }

    // Retrieves all courses and returns them as a list of CourseDTOs
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream() // Fetches all courses
                .map(CourseFactory::createCourseDTO) // Converts each Course to CourseDTO
                .collect(Collectors.toList()); // Collects and returns as a list
    }

    // Updates an existing course identified by its ID
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = CourseFactory.createCourse(courseDTO); // Converts DTO to entity
        course.setId(id); // Sets the ID for the entity
        return CourseFactory.createCourseDTO(courseRepository.save(course)); // Saves and returns DTO
    }

    // Deletes a course by its ID
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id); // Deletes the course from the repository
    }
}