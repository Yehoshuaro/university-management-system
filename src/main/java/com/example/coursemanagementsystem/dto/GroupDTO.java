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
public class GroupDTO {
    private Long id;
    private String name;
    private String description;
    private Integer year;
}