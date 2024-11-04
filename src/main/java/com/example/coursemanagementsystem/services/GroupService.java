package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.dto.GroupDTO; // Data Transfer Object for Group
import com.example.coursemanagementsystem.entities.Group; // Entity class representing Group
import com.example.coursemanagementsystem.repositories.GroupRepository; // Repository interface for Group
import com.example.coursemanagementsystem.services.factory.GroupFactory; // Factory for Group and GroupDTO creation
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // Indicates that this class is a service component
public class GroupService {

    @Autowired
    private GroupRepository groupRepository; // Injects the GroupRepository

    // Saves a new group and returns the corresponding GroupDTO
    public GroupDTO saveGroup(GroupDTO groupDTO) {
        Group group = GroupFactory.createGroup(groupDTO); // Converts DTO to entity
        return GroupFactory.createGroupDTO(groupRepository.save(group)); // Saves and converts back to DTO
    }

    // Retrieves a group by its ID and returns the corresponding GroupDTO
    public GroupDTO getGroupById(Long id) {
        return groupRepository.findById(id) // Finds the group by ID
                .map(GroupFactory::createGroupDTO) // Converts to DTO if present
                .orElse(null); // Returns null if not found
    }

    // Retrieves all groups and returns them as a list of GroupDTOs
    public List<GroupDTO> getAllGroups() {
        return groupRepository.findAll().stream() // Fetches all groups
                .map(GroupFactory::createGroupDTO) // Converts each Group to GroupDTO
                .collect(Collectors.toList()); // Collects and returns as a list
    }

    // Updates an existing group identified by its ID
    public GroupDTO updateGroup(Long id, GroupDTO groupDTO) {
        Group group = GroupFactory.createGroup(groupDTO); // Converts DTO to entity
        group.setId(id); // Sets the ID for the entity
        return GroupFactory.createGroupDTO(groupRepository.save(group)); // Saves and returns DTO
    }

    // Deletes a group by its ID
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id); // Deletes the group from the repository
    }
}