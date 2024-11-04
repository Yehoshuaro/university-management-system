package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.dto.UserDTO;
import com.example.coursemanagementsystem.entities.User;
import com.example.coursemanagementsystem.repositories.UserRepository;
import com.example.coursemanagementsystem.services.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO saveUser(UserDTO userDTO) {
        User user = UserFactory.createUser(userDTO);
        return UserFactory.createUserDTO(userRepository.save(user));
    }

    public UserDTO getUserById(Integer id) {
        return userRepository.findById(id)
                .map(UserFactory::createUserDTO)
                .orElse(null);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserFactory::createUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        User user = UserFactory.createUser(userDTO);
        user.setId(id);
        return UserFactory.createUserDTO(userRepository.save(user));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}