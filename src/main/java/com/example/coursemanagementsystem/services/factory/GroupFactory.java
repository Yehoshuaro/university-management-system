package com.example.coursemanagementsystem.services.factory;

import com.example.coursemanagementsystem.dto.GroupDTO;
import com.example.coursemanagementsystem.entities.Group;

public class GroupFactory {

    public static Group createGroup(GroupDTO groupDTO) {
        return Group.builder()
                .id(groupDTO.getId())
                .name(groupDTO.getName())
                .description(groupDTO.getDescription())
                .year(groupDTO.getYear())
                .build();
    }

    public static GroupDTO createGroupDTO(Group group) {
        return GroupDTO.builder()
                .id(group.getId())
                .name(group.getName())
                .description(group.getDescription())
                .year(group.getYear())
                .build();
    }
}