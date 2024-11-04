package com.example.coursemanagementsystem.dto;

import lombok.*;

/**
 * Data Transfer Object (DTO) for representing course information.
 * This class is used to transfer course data between different layers of the application,
 * such as between the controller and the service layer.
 */
@Getter
@Setter
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with arguments for all fields
@Builder // Enables the builder pattern for creating instances of this class
public class CourseDTO {

    /** Unique identifier for the course */
    private Long id;

    /** Title or name of the course */
    private String title;

    /** Description providing details about the course content */
    private String description;

    /** Number of credits assigned to the course */
    private Integer credits;
}
