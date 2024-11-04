package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.dto.UserDTO; // Data Transfer Object for User
import com.example.coursemanagementsystem.services.UserService; // Service for user operations
import org.springframework.beans.factory.annotation.Autowired; // Annotation for dependency injection
import org.springframework.http.ResponseEntity; // Wrapper for HTTP responses
import org.springframework.web.bind.annotation.*; // Annotations for RESTful web services

import java.util.List; // List interface for collections

@RestController // Indicates that this class is a REST controller
@RequestMapping("/users") // Base URL for all endpoints in this controller
public class UserController {

    @Autowired // Injects UserService bean
    private UserService userService;

    // Endpoint to create a new user
    @PostMapping // Maps POST requests to this method
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        // Calls the service to save the user and returns the created user
        UserDTO createdUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(createdUser); // Returns 200 OK with the created user
    }

    // Endpoint to retrieve a user by its ID
    @GetMapping("/{id}") // Maps GET requests with user ID to this method
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        // Calls the service to get the user by ID
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user); // Returns 200 OK with the user details
    }

    // Endpoint to retrieve all users
    @GetMapping // Maps GET requests to this method
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        // Calls the service to get all users
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users); // Returns 200 OK with the list of users
    }

    // Endpoint to update a user by its ID
    @PutMapping("/{id}") // Maps PUT requests with user ID to this method
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        // Calls the service to update the user and returns the updated user
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUser); // Returns 200 OK with the updated user
    }

    // Endpoint to delete a user by its ID
    @DeleteMapping("/{id}") // Maps DELETE requests with user ID to this method
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id); // Calls the service to delete the user
        return ResponseEntity.noContent().build(); // Returns 204 No Content to indicate successful deletion
    }
}