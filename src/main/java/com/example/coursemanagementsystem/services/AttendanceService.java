package com.example.coursemanagementsystem.services;

import com.example.coursemanagementsystem.entities.Attendance;
import com.example.coursemanagementsystem.entities.Course;
import com.example.coursemanagementsystem.entities.User;
import com.example.coursemanagementsystem.repositories.AttendanceRepository;
import com.example.coursemanagementsystem.repositories.CourseRepository;
import com.example.coursemanagementsystem.repositories.UserRepository;
import com.example.coursemanagementsystem.services.serviceInterface.AttendanceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService implements AttendanceServiceInterface {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Attendance markAttendance(Integer student_id, Long courseId, boolean attended) {
        User student = userRepository.findById(student_id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Attendance attendance = Attendance.builder()
                .student(student)
                .course(course)
                .date(LocalDate.now())
                .attended(attended)
                .build();

        return attendanceRepository.save(attendance);
    }
    public List<Attendance> getAttendanceByStudentAndCourse(Integer student_id, Long courseId) {
        return attendanceRepository.findByStudentIdAndCourseId(student_id, courseId);
    }
}
