package com.example.coursemanagementsystem.services.factory;

import com.example.coursemanagementsystem.dto.UserDTO; // Data Transfer Object for User
import com.example.coursemanagementsystem.entities.User; // Entity class representing User
import com.example.coursemanagementsystem.entities.Group; // Entity class representing Group
import com.example.coursemanagementsystem.entities.Role; // Enum representing User roles

// Factory class for creating User and UserDTO objects
public class UserFactory {

    // Creates a User entity from a UserDTO
    public static User createUser(UserDTO userDTO) {
        Group group = new Group(); // Create a new Group instance
        group.setId(userDTO.getGroupId()); // Set the group ID from the DTO

        return User.builder() // Uses the builder pattern for creating User instances
                .id(userDTO.getId()) // Sets the ID from the DTO
                .firstName(userDTO.getFirstName()) // Sets the first name from the DTO
                .lastName(userDTO.getLastName()) // Sets the last name from the DTO
                .email(userDTO.getEmail()) // Sets the email from the DTO
                .password(userDTO.getPassword()) // Sets the password from the DTO
                .role(Role.valueOf(userDTO.getRole())) // Sets the role by converting the string to the Role enum
                .group(group) // Associates the group with the user
                .build(); // Builds and returns the User instance
    }

    // Creates a UserDTO from a User entity
    public static UserDTO createUserDTO(User user) {
        return UserDTO.builder() // Uses the builder pattern for creating UserDTO instances
                .id(user.getId()) // Sets the ID from the entity
                .firstName(user.getFirstName()) // Sets the first name from the entity
                .lastName(user.getLastName()) // Sets the last name from the entity
                .email(user.getEmail()) // Sets the email from the entity
                .password(user.getPassword()) // Sets the password from the entity
                .role(user.getRole().name()) // Converts the Role enum to a string
                .groupId(user.getGroup().getId()) // Sets the group ID from the user's group
                .build(); // Builds and returns the UserDTO instance
    }
}