package com.example.coursemanagementsystem.Course;

import com.example.coursemanagementsystem.Student.StudentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="course/")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController (CourseService courseService) {
        this.courseService = courseService;
    }
}
