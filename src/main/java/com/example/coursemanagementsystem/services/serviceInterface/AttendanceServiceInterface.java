package com.example.coursemanagementsystem.services.serviceInterface;

import com.example.coursemanagementsystem.entities.Attendance;

public interface AttendanceServiceInterface {
    Attendance markAttendance(Integer student_id, Long course_id, boolean attended);
}
