/* The Teacher class represents an instructor who is responsible
for teaching specific subjects to different student groups. Each teacher
has attributes like their name, assigned subject, and a list of
groups they teach. This setup allows the system to organize teachers by
their subject expertise and allocate them to appropriate groups */


package com.example.coursemanagementsystem.Teacher;

import com.example.coursemanagementsystem.Course.Course;

import java.util.List;

public class Teacher {
    private Long id;
    private String name;
    private List<Course> courses;

    public Teacher(Long id, String name, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}