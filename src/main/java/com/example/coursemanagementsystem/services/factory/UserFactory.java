package com.example.coursemanagementsystem.services.factory;

import com.example.coursemanagementsystem.dto.UserDTO;
import com.example.coursemanagementsystem.entities.User;
import com.example.coursemanagementsystem.entities.Group;
import com.example.coursemanagementsystem.entities.Role;

public class UserFactory {

    public static User createUser(UserDTO userDTO) {
        Group group = new Group();
        group.setId(userDTO.getGroupId());
        return User.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .role(Role.valueOf(userDTO.getRole()))
                .group(group)
                .build();
    }

    public static UserDTO createUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole().name())
                .groupId(user.getGroup().getId())
                .build();
    }
}