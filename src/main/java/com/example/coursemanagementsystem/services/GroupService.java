package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.dto.GroupDTO;
import com.example.coursemanagementsystem.entities.Group;
import com.example.coursemanagementsystem.repositories.GroupRepository;
import com.example.coursemanagementsystem.services.factory.GroupFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public GroupDTO saveGroup(GroupDTO groupDTO) {
        Group group = GroupFactory.createGroup(groupDTO);
        return GroupFactory.createGroupDTO(groupRepository.save(group));
    }

    public GroupDTO getGroupById(Long id) {
        return groupRepository.findById(id)
                .map(GroupFactory::createGroupDTO)
                .orElse(null);
    }

    public List<GroupDTO> getAllGroups() {
        return groupRepository.findAll().stream()
                .map(GroupFactory::createGroupDTO)
                .collect(Collectors.toList());
    }

    public GroupDTO updateGroup(Long id, GroupDTO groupDTO) {
        Group group = GroupFactory.createGroup(groupDTO);
        group.setId(id);
        return GroupFactory.createGroupDTO(groupRepository.save(group));
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}