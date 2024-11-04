package com.example.coursemanagementsystem.auth;

import lombok.RequiredArgsConstructor; // Lombok annotation to generate a constructor
import org.springframework.http.ResponseEntity; // Spring's ResponseEntity for HTTP responses
import org.springframework.web.bind.annotation.PostMapping; // Annotation for POST requests
import org.springframework.web.bind.annotation.RequestBody; // Annotation for request body mapping
import org.springframework.web.bind.annotation.RequestMapping; // Annotation for request mapping at class level
import org.springframework.web.bind.annotation.RestController; // Annotation to indicate this class is a REST controller

@RestController // Indicates that this class handles HTTP requests
@RequestMapping("/auth") // Maps all requests to /auth
@RequiredArgsConstructor // Generates a constructor for the final fields (Dependency Injection)
public class AuthenticationController {

    private final AuthenticationService service; // Service for handling authentication logic

    // Endpoint for user registration
    @PostMapping("/register") // Maps POST requests to /auth/register
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody RegisterRequest request // Maps request body to RegisterRequest object
    ) {
        // Calls the register method of the service and returns the response
        return ResponseEntity.ok(service.register(request));
    }

    // Endpoint for user authentication
    @PostMapping("/authenticate") // Maps POST requests to /auth/authenticate
    public ResponseEntity<AuthenticationResponse> authenticate (
            @RequestBody AuthenticationRequest request // Maps request body to AuthenticationRequest object
    ) {
        // Calls the authenticate method of the service and returns the response
        return ResponseEntity.ok(service.authenticate(request));
    }
}