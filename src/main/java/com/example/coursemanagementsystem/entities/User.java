package com.example.coursemanagementsystem.entities;

import java.util.List; // List interface for collections
import jakarta.persistence.*; // JPA annotations for entity management
import lombok.*; // Lombok annotations for boilerplate code generation
import org.springframework.security.core.GrantedAuthority; // Interface for granted authorities
import org.springframework.security.core.authority.SimpleGrantedAuthority; // Implementation of GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails; // Interface for user details

import java.util.Collection; // Collection interface for grouping

@Getter // Lombok annotation to generate getter methods
@Setter // Lombok annotation to generate setter methods
@Builder // Lombok annotation to support the builder pattern
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@Entity // Indicates that this class is a JPA entity
@Table(name = "users") // Specifies the table name in the database
public class User implements UserDetails {

    @Id // Indicates the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates the primary key value
    private Integer id; // Unique identifier for the user

    private String firstName; // User's first name
    private String lastName; // User's last name
    private String email; // User's email address
    private String password; // User's password

    @Enumerated(EnumType.STRING) // Stores the role as a string in the database
    private Role role; // Role of the user (ADMIN, STUDENT, TEACHER)

    @ManyToOne // Defines a many-to-one relationship with the Group entity
    @JoinColumn(name = "group_id") // Foreign key column in the users table
    private Group group; // The group to which the user belongs

    @ManyToMany // Defines a many-to-many relationship with the Course entity
    @JoinTable( // Specifies the join table for the many-to-many relationship
            name = "user_courses", // Name of the join table
            joinColumns = @JoinColumn(name = "user_id"), // Column for user ID
            inverseJoinColumns = @JoinColumn(name = "course_id") // Column for course ID
    )
    private List<Course> courses; // List of courses the user is enrolled in

    // Returns the authorities granted to the user based on their role
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name())); // Converts the role to a GrantedAuthority
    }

    @Override
    public String getPassword() {
        return password; // Returns the user's password
    }

    @Override
    public String getUsername() {
        return email; // Returns the user's email as the username
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Indicates that the account is not expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Indicates that the account is not locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Indicates that the credentials are not expired
    }

    @Override
    public boolean isEnabled() {
        return true; // Indicates that the account is enabled
    }
}