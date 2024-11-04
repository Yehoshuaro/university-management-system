package com.example.coursemanagementsystem.services.factory;

import com.example.coursemanagementsystem.dto.CourseDTO; // Data Transfer Object for Course
import com.example.coursemanagementsystem.entities.Course; // Entity class representing Course

// Factory class for creating Course and CourseDTO objects
public class CourseFactory {

    // Creates a Course entity from a CourseDTO
    public static Course createCourse(CourseDTO courseDTO) {
        return Course.builder() // Uses the builder pattern for creating Course instances
                .id(courseDTO.getId()) // Sets the ID from the DTO
                .title(courseDTO.getTitle()) // Sets the title from the DTO
                .description(courseDTO.getDescription()) // Sets the description from the DTO
                .credits(courseDTO.getCredits()) // Sets the credits from the DTO
                .build(); // Builds and returns the Course instance
    }

    // Creates a CourseDTO from a Course entity
    public static CourseDTO createCourseDTO(Course course) {
        return CourseDTO.builder() // Uses the builder pattern for creating CourseDTO instances
                .id(course.getId()) // Sets the ID from the entity
                .title(course.getTitle()) // Sets the title from the entity
                .description(course.getDescription()) // Sets the description from the entity
                .credits(course.getCredits()) // Sets the credits from the entity
                .build(); // Builds and returns the CourseDTO instance
    }
}