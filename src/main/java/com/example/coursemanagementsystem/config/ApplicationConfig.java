package com.example.coursemanagementsystem.config;

import com.example.coursemanagementsystem.repositories.UserRepository; // Repository for user data access
import lombok.RequiredArgsConstructor; // Lombok annotation to generate a constructor
import org.springframework.context.annotation.Bean; // Annotation for defining a bean
import org.springframework.context.annotation.Configuration; // Indicates that this class provides Spring configuration
import org.springframework.security.authentication.AuthenticationManager; // Manages authentication
import org.springframework.security.authentication.AuthenticationProvider; // Interface for authentication logic
import org.springframework.security.authentication.dao.DaoAuthenticationProvider; // Provider that uses a UserDetailsService
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration; // Configuration for authentication
import org.springframework.security.core.userdetails.UserDetailsService; // Service for loading user-specific data
import org.springframework.security.core.userdetails.UsernameNotFoundException; // Exception for user not found
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // BCrypt encoder for password hashing
import org.springframework.security.crypto.password.PasswordEncoder; // Interface for password encoding

@Configuration // Marks this class as a source of bean definitions
@RequiredArgsConstructor // Generates a constructor for the final fields (Dependency Injection)
public class ApplicationConfig {

    private final UserRepository repository; // Repository for user data

    // Bean definition for UserDetailsService
    @Bean
    public UserDetailsService userDetailsService() {
        // Loads user by email, throws exception if not found
        return username -> repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    // Bean definition for AuthenticationProvider
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService()); // Sets the user details service
        authProvider.setPasswordEncoder(passwordEncoder()); // Sets the password encoder
        return authProvider; // Returns the configured authentication provider
    }

    // Bean definition for AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager(); // Retrieves and returns the authentication manager
    }

    // Bean definition for PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Returns a BCrypt password encoder for hashing
    }
}