package com.example.coursemanagementsystem.auth;

import lombok.AllArgsConstructor; // Lombok annotation to generate a constructor with all fields
import lombok.Builder; // Lombok annotation to provide a builder pattern for this class
import lombok.Data; // Lombok annotation to generate getters, setters, and other utility methods
import lombok.NoArgsConstructor; // Lombok annotation to generate a no-argument constructor

@Data // Generates getters, setters, toString, equals, and hashCode methods
@Builder // Enables the builder pattern for object creation
@AllArgsConstructor // Generates a constructor that accepts all fields
@NoArgsConstructor // Generates a no-argument constructor
public class RegisterRequest {
    private String firstName; // User's first name for registration
    private String lastName; // User's last name for registration
    private String email; // User's email address for registration
    private String password; // User's password for registration
}