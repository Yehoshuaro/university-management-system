package com.example.coursemanagementsystem.config;

import jakarta.servlet.FilterChain; // Interface for filter chain
import jakarta.servlet.ServletException; // Exception for servlet-related errors
import jakarta.servlet.http.HttpServletRequest; // Interface for HTTP requests
import jakarta.servlet.http.HttpServletResponse; // Interface for HTTP responses
import lombok.NonNull; // Annotation to indicate a parameter must not be null
import lombok.RequiredArgsConstructor; // Lombok annotation to generate a constructor
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; // Token for user authentication
import org.springframework.security.core.context.SecurityContextHolder; // Holds security context
import org.springframework.security.core.userdetails.UserDetails; // Interface for user details
import org.springframework.security.core.userdetails.UserDetailsService; // Service for loading user-specific data
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; // Filter for username/password authentication
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource; // Provides details for web authentication
import org.springframework.stereotype.Component; // Indicates that this class is a Spring component
import org.springframework.web.filter.OncePerRequestFilter; // Filter that is invoked once per request

import java.io.IOException; // Exception for I/O operations

@Component // Marks this class as a Spring component
@RequiredArgsConstructor // Generates a constructor for the final fields (Dependency Injection)
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService; // Service for JWT token management
    private final UserDetailsService userDetailsService; // Service for loading user details

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request, // Incoming HTTP request
            @NonNull HttpServletResponse response, // HTTP response
            @NonNull FilterChain filterChain) // Filter chain for processing the request
            throws ServletException, IOException {

        // Retrieves the Authorization header from the request
        final String authHeader = request.getHeader("Authorization");
        final String jwt; // JWT token
        final String userEmail; // User's email extracted from the JWT

        // Checks if the Authorization header is present and starts with "Bearer "
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response); // Continues the filter chain
            return; // Exits if the header is invalid
        }

        // Extracts the JWT token from the header
        jwt = authHeader.substring(7);
        // Extracts the username (email) from the JWT token
        userEmail = jwtService.extractUsername(jwt);

        // Checks if the email is not null and no authentication is currently set
        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Loads user details using the email
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            // Validates the JWT token
            if (jwtService.isTokenValid(jwt, userDetails)) {
                // Creates an authentication token for the user
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities() // Sets user authorities
                );
                // Sets additional details for the authentication token
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                // Sets the authentication in the security context
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        // Continues the filter chain
        filterChain.doFilter(request, response);
    }
}