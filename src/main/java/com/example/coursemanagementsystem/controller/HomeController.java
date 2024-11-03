package com.example.coursemanagementsystem.controller;

import com.example.coursemanagementsystem.teacher.Assignment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AuthenticationManager authenticationManager;

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
        model.addAttribute("assignments", List.of(
                new Assignment("Project 1", "2024-12-15"),
                new Assignment("Assignment 2", "2024-11-20")
        ));
        return "teacher-main-page";
    }

    @GetMapping("/student-profile")
    public String profile(Model model) {
        return "student-profile";
    }

    @GetMapping("/deadlines")
    public String deadlinesPage(Model model) {
        model.addAttribute("assignments");
        return "deadlines";
    }

    @GetMapping("/sign-in")
    public String signInPage(Model model) {
        return "sign-in";
    }
}


//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(username, password)
//            );
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            return "redirect:/home";
//        } catch (Exception e) {
//            return "redirect:/sign-in?error";
//        }
//    }
//}
