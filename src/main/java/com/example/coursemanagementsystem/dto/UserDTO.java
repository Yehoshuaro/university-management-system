package com.example.coursemanagementsystem.dto;

import lombok.*;
/**
 * Data Transfer Object (DTO) for representing course information.
 * This class is used to transfer course data between different layers of the application,
 * such as between the controller and the service layer.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private Long groupId;
}