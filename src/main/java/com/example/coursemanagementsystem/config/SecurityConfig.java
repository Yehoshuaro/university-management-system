package com.example.coursemanagementsystem.config;

import jakarta.servlet.Filter; // Interface for servlet filters
import lombok.RequiredArgsConstructor; // Lombok annotation to generate a constructor
import org.apache.catalina.filters.CorsFilter; // CORS filter for Apache Catalina (not used here)
import org.springframework.context.annotation.Bean; // Annotation for defining a bean
import org.springframework.context.annotation.Configuration; // Indicates that this class provides Spring configuration
import org.springframework.security.authentication.AuthenticationProvider; // Interface for authentication logic
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Configures HTTP security
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; // Enables Spring Security configuration
import org.springframework.security.config.http.SessionCreationPolicy; // Policy for session management
import org.springframework.security.web.SecurityFilterChain; // Defines a filter chain for security
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; // Filter for username/password authentication
import org.springframework.web.cors.CorsConfiguration; // CORS configuration class
import org.springframework.web.cors.CorsConfigurationSource; // Interface for CORS configuration source
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource; // CORS configuration source based on URL

import java.util.List; // List interface for collections

@Configuration // Marks this class as a configuration class for Spring
@EnableWebSecurity // Enables Spring Security for the application
@RequiredArgsConstructor // Generates a constructor for the final fields (Dependency Injection)
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter; // JWT authentication filter
    private final AuthenticationProvider authenticationProvider; // Authentication provider

    // Bean definition for the security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disables CSRF protection
                .authorizeHttpRequests(authorize -> authorize // Configures request authorization
                        .requestMatchers("/auth/**").permitAll() // Allows public access to /auth/** endpoints
                        .anyRequest().anonymous() // Allows anonymous access to any other request
                )
                .sessionManagement(session -> session // Configures session management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Sets stateless session policy
                )
                .authenticationProvider(authenticationProvider) // Sets the authentication provider
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // Adds JWT filter before the username/password authentication filter

        return http.build(); // Builds and returns the security filter chain
    }
}