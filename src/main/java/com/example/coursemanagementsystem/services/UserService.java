package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.dto.UserDTO; // Data Transfer Object for User
import com.example.coursemanagementsystem.entities.User; // Entity class representing User
import com.example.coursemanagementsystem.repositories.UserRepository; // Repository interface for User
import com.example.coursemanagementsystem.services.factory.UserFactory; // Factory for User and UserDTO creation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Indicates that this class is a service component
public class UserService {

    @Autowired
    private UserRepository userRepository; // Injects the UserRepository

    // Saves a new user and returns the corresponding UserDTO
    public UserDTO saveUser(UserDTO userDTO) {
        User user = UserFactory.createUser(userDTO); // Converts DTO to entity
        return UserFactory.createUserDTO(userRepository.save(user)); // Saves and converts back to DTO
    }

    // Retrieves a user by their ID and returns the corresponding UserDTO
    public UserDTO getUserById(Integer id) {
        return userRepository.findById(id) // Finds the user by ID
                .map(UserFactory::createUserDTO) // Converts to DTO if present
                .orElse(null); // Returns null if not found
    }

    // Retrieves all users and returns them as a list of UserDTOs
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream() // Fetches all users
                .map(UserFactory::createUserDTO) // Converts each User to UserDTO
                .collect(Collectors.toList()); // Collects and returns as a list
    }

    // Updates an existing user identified by their ID
    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        User user = UserFactory.createUser(userDTO); // Converts DTO to entity
        user.setId(id); // Sets the ID for the entity
        return UserFactory.createUserDTO(userRepository.save(user)); // Saves and returns DTO
    }

    // Deletes a user by their ID
    public void deleteUser(Integer id) {
        userRepository.deleteById(id); // Deletes the user from the repository
    }
}