package com.example.coursemanagementsystem.repositories;

import com.example.coursemanagementsystem.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    List<Attendance> findByStudentIdAndCourseId(Integer student_id, Long courseId);
}
