package com.example.coursemanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to the Moodle!");
        return "main-page";
    }
    @GetMapping("/course-detail-student")
    public String courseDetailStudent(Model model) {
        model.addAttribute("instructorName", "John Teacher");
        model.addAttribute("grade", "A+");
        model.addAttribute("students");
        return "course-detail-student";
    }
    @GetMapping("/teacher-main-page")
    public String teacherMainPage(Model model) {
        return "teacher-main-page";
    }
    @GetMapping("/student-profile")
    public String profile(Model model) {
        return "student-profile";
    }
    @GetMapping("/deadlines")
    public String deadlinesPage(Model model) {
        // Задаем список заданий с дедлайнами
        model.addAttribute("assignments");
        return "deadlines";
    }
}
