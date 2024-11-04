package com.example.coursemanagementsystem.services.factory;

import com.example.coursemanagementsystem.dto.GroupDTO; // Data Transfer Object for Group
import com.example.coursemanagementsystem.entities.Group; // Entity class representing Group

// Factory class for creating Group and GroupDTO objects
public class GroupFactory {

    // Creates a Group entity from a GroupDTO
    public static Group createGroup(GroupDTO groupDTO) {
        return Group.builder() // Uses the builder pattern for creating Group instances
                .id(groupDTO.getId()) // Sets the ID from the DTO
                .name(groupDTO.getName()) // Sets the name from the DTO
                .description(groupDTO.getDescription()) // Sets the description from the DTO
                .year(groupDTO.getYear()) // Sets the year from the DTO
                .build(); // Builds and returns the Group instance
    }

    // Creates a GroupDTO from a Group entity
    public static GroupDTO createGroupDTO(Group group) {
        return GroupDTO.builder() // Uses the builder pattern for creating GroupDTO instances
                .id(group.getId()) // Sets the ID from the entity
                .name(group.getName()) // Sets the name from the entity
                .description(group.getDescription()) // Sets the description from the entity
                .year(group.getYear()) // Sets the year from the entity
                .build(); // Builds and returns the GroupDTO instance
    }
}