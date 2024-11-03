package com.example.coursemanagementsystem.services.factory;

import com.example.coursemanagementsystem.dto.CourseDTO;
import com.example.coursemanagementsystem.entities.Course;

public class CourseFactory {

    public static Course createCourse(CourseDTO courseDTO) {
        return Course.builder()
                .id(courseDTO.getId())
                .title(courseDTO.getTitle())
                .description(courseDTO.getDescription())
                .credits(courseDTO.getCredits())
                .build();
    }

    public static CourseDTO createCourseDTO(Course course) {
        return CourseDTO.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .credits(course.getCredits())
                .build();
    }
}