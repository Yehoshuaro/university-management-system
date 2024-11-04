package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.dto.CourseDTO; // Data Transfer Object for Course
import com.example.coursemanagementsystem.services.CourseService; // Service for course operations
import org.springframework.beans.factory.annotation.Autowired; // Annotation for dependency injection
import org.springframework.http.ResponseEntity; // Wrapper for HTTP responses
import org.springframework.web.bind.annotation.*; // Annotations for RESTful web services

import java.util.List; // List interface for collections

@RestController // Indicates that this class is a REST controller
@RequestMapping("/courses") // Base URL for all endpoints in this controller
public class CourseController {

    @Autowired // Injects CourseService bean
    private CourseService courseService;

    // Endpoint to create a new course
    @PostMapping // Maps POST requests to this method
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        // Calls the service to save the course and returns the created course
        CourseDTO createdCourse = courseService.saveCourse(courseDTO);
        return ResponseEntity.ok(createdCourse); // Returns 200 OK with the created course
    }

    // Endpoint to retrieve a course by its ID
    @GetMapping("/{id}") // Maps GET requests with course ID to this method
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        // Calls the service to get the course by ID
        CourseDTO course = courseService.getCourseById(id);
        return ResponseEntity.ok(course); // Returns 200 OK with the course details
    }

    // Endpoint to retrieve all courses
    @GetMapping // Maps GET requests to this method
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        // Calls the service to get all courses
        List<CourseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses); // Returns 200 OK with the list of courses
    }

    // Endpoint to update a course by its ID
    @PutMapping("/{id}") // Maps PUT requests with course ID to this method
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        // Calls the service to update the course and returns the updated course
        CourseDTO updatedCourse = courseService.updateCourse(id, courseDTO);
        return ResponseEntity.ok(updatedCourse); // Returns 200 OK with the updated course
    }

    // Endpoint to delete a course by its ID
    @DeleteMapping("/{id}") // Maps DELETE requests with course ID to this method
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id); // Calls the service to delete the course
        return ResponseEntity.noContent().build(); // Returns 204 No Content to indicate successful deletion
    }
}