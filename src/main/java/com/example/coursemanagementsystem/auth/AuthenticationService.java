package com.example.coursemanagementsystem.auth;

import com.example.coursemanagementsystem.config.JwtService; // Service for JWT token management
import com.example.coursemanagementsystem.entities.Role; // Role enumeration for user roles
import com.example.coursemanagementsystem.entities.User; // User entity representing the user
import com.example.coursemanagementsystem.repositories.UserRepository; // Repository for user data access
import lombok.RequiredArgsConstructor; // Lombok annotation to generate a constructor
import org.springframework.security.authentication.AuthenticationManager; // Manages authentication
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; // Token for user authentication
import org.springframework.security.crypto.password.PasswordEncoder; // For encoding passwords
import org.springframework.stereotype.Service; // Indicates that this class is a service component

@Service // Marks this class as a service
@RequiredArgsConstructor // Generates a constructor for the final fields (Dependency Injection)
public class AuthenticationService {

    private final UserRepository repository; // Repository for user data
    private final PasswordEncoder passwordEncoder; // Encoder for passwords
    private final JwtService jwtService; // Service for generating JWT tokens
    private final AuthenticationManager authenticationManager; // Manages user authentication

    // Method for registering a new user
    public AuthenticationResponse register(RegisterRequest request) {
        // Creates a new User object using data from the registration request
        var user = User.builder()
                .firstName(request.getFirstName()) // Sets first name
                .lastName(request.getLastName()) // Sets last name
                .email(request.getEmail()) // Sets email
                .password(passwordEncoder.encode(request.getPassword())) // Encodes the password
                .role(Role.STUDENT) // Assigns a default role of STUDENT
                .build(); // Builds the User object

        // Saves the new user to the repository
        repository.save(user);

        // Generates a JWT token for the newly registered user
        var jwtToken = jwtService.generateToken(user);

        // Returns the authentication response containing the token
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    // Method for authenticating an existing user
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // Authenticates the user with the provided email and password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), // User's email
                        request.getPassword() // User's password
                )
        );

        // Retrieves the user from the repository by email
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(); // Throws an exception if user not found

        // Generates a JWT token for the authenticated user
        var jwtToken = jwtService.generateToken(user);

        // Returns the authentication response containing the token
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}