package com.example.coursemanagementsystem.demo;

import org.springframework.http.ResponseEntity; // Wrapper for HTTP responses
import org.springframework.web.bind.annotation.GetMapping; // Annotation for GET requests
import org.springframework.web.bind.annotation.RequestMapping; // Annotation for request mapping
import org.springframework.web.bind.annotation.RestController; // Indicates that this class is a REST controller

@RestController // Marks this class as a REST controller
@RequestMapping("/demo-controller") // Base URL for all endpoints in this controller
public class DemoController {

    // Endpoint to return a greeting message
    @GetMapping // Maps GET requests to this method
    public ResponseEntity<String> sayHello() {
        // Returns a 200 OK response with a greeting message
        return ResponseEntity.ok("Hello from secured endpoint");
    }
}