/* The Group class represents a collection of students who are learning
 a particular subject together. Each group has a unique identifier and
 a list of students who belong to that group. Groups are used to manage the
 distribution of students under different teachers */

package com.example.coursemanagementsystem.Group;

import com.example.coursemanagementsystem.Student.Student;

import java.util.List;

public class Group {
    private Long id;
    private String groupName;
    private List<Student> students;

    public Group() {
    }

    public Group(Long id, String groupName, List<Student> students) {
        this.id = id;
        this.groupName = groupName;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", students=" + students +
                '}';
    }
}
