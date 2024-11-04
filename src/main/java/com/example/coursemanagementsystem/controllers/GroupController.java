package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.dto.GroupDTO; // Data Transfer Object for Group
import com.example.coursemanagementsystem.services.GroupService; // Service for group operations
import org.springframework.beans.factory.annotation.Autowired; // Annotation for dependency injection
import org.springframework.http.ResponseEntity; // Wrapper for HTTP responses
import org.springframework.web.bind.annotation.*; // Annotations for RESTful web services

import java.util.List; // List interface for collections

@RestController // Indicates that this class is a REST controller
@RequestMapping("/groups") // Base URL for all endpoints in this controller
public class GroupController {

    @Autowired // Injects GroupService bean
    private GroupService groupService;

    // Endpoint to create a new group
    @PostMapping // Maps POST requests to this method
    public ResponseEntity<GroupDTO> createGroup(@RequestBody GroupDTO groupDTO) {
        // Calls the service to save the group and returns the created group
        GroupDTO createdGroup = groupService.saveGroup(groupDTO);
        return ResponseEntity.ok(createdGroup); // Returns 200 OK with the created group
    }

    // Endpoint to retrieve a group by its ID
    @GetMapping("/{id}") // Maps GET requests with group ID to this method
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable Long id) {
        // Calls the service to get the group by ID
        GroupDTO group = groupService.getGroupById(id);
        return ResponseEntity.ok(group); // Returns 200 OK with the group details
    }

    // Endpoint to retrieve all groups
    @GetMapping // Maps GET requests to this method
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        // Calls the service to get all groups
        List<GroupDTO> groups = groupService.getAllGroups();
        return ResponseEntity.ok(groups); // Returns 200 OK with the list of groups
    }

    // Endpoint to update a group by its ID
    @PutMapping("/{id}") // Maps PUT requests with group ID to this method
    public ResponseEntity<GroupDTO> updateGroup(@PathVariable Long id, @RequestBody GroupDTO groupDTO) {
        // Calls the service to update the group and returns the updated group
        GroupDTO updatedGroup = groupService.updateGroup(id, groupDTO);
        return ResponseEntity.ok(updatedGroup); // Returns 200 OK with the updated group
    }

    // Endpoint to delete a group by its ID
    @DeleteMapping("/{id}") // Maps DELETE requests with group ID to this method
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id); // Calls the service to delete the group
        return ResponseEntity.noContent().build(); // Returns 204 No Content to indicate successful deletion
    }
}