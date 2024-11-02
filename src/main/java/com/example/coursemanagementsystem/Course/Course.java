package com.example.coursemanagementsystem.Course;

import org.yaml.snakeyaml.constructor.Constructor;

import java.time.LocalDate;

public class Course {
    private Long id;
    private String courseName;

    public Course() {
    }

    public Course(Long id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public Long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
