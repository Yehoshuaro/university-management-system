package com.example.coursemanagementsystem.entities;

import jakarta.persistence.*; // JPA annotations for entity management
import lombok.*; // Lombok annotations for boilerplate code generation

import java.util.List; // List interface for collections

@Getter // Lombok annotation to generate getter methods
@Setter // Lombok annotation to generate setter methods
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@Builder // Lombok annotation to support the builder pattern
@Entity // Indicates that this class is a JPA entity
@Table(name = "groups") // Specifies the table name in the database
public class Group {

    @Id // Indicates the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key value
    private Long id; // Unique identifier for the group

    private String name; // Name of the group
    private String description; // Description of the group
    private Integer year; // Year associated with the group

    @OneToMany(mappedBy = "group") // Defines a one-to-many relationship with the User entity
    private List<User> students; // List of students belonging to the group
}