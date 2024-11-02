package com.example.coursemanagementsystem.Student;

import java.time.LocalDate;

public class Student {
    private Long id;
    private String name;
    private String surname;
    private LocalDate dob;
    private String email;

    public Student() {
    }

    public Student(Long id, String name, String surname, LocalDate dob, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
