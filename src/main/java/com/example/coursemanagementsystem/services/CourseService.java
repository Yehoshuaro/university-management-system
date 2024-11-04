package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.dto.CourseDTO;
import com.example.coursemanagementsystem.entities.Course;
import com.example.coursemanagementsystem.repositories.CourseRepository;
import com.example.coursemanagementsystem.services.factory.CourseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseDTO saveCourse(CourseDTO courseDTO) {
        Course course = CourseFactory.createCourse(courseDTO);
        return CourseFactory.createCourseDTO(courseRepository.save(course));
    }

    public CourseDTO getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(CourseFactory::createCourseDTO)
                .orElse(null);
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(CourseFactory::createCourseDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = CourseFactory.createCourse(courseDTO);
        course.setId(id);
        return CourseFactory.createCourseDTO(courseRepository.save(course));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}