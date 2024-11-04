package com.example.coursemanagementsystem.controllers;

import com.example.coursemanagementsystem.entities.Attendance;
import com.example.coursemanagementsystem.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/{student_id}/{courseId}")
    public Attendance markAttendance(@PathVariable Integer student_id, @PathVariable Long courseId, @RequestBody boolean attended){
        return attendanceService.markAttendance(student_id, courseId, attended);
    }
    @GetMapping("/{student_id}/{courseId}")
    public List<Attendance> getAttendance(@PathVariable Integer student_id, @PathVariable Long courseId) {
        return attendanceService.getAttendanceByStudentAndCourse(student_id, courseId);
    }
}
