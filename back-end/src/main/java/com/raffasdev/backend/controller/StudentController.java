package com.raffasdev.backend.controller;

import com.raffasdev.backend.domain.Attendance;
import com.raffasdev.backend.domain.Lesson;
import com.raffasdev.backend.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/students")
public class StudentController {

    @GetMapping()
    public List<Attendance> getStudents() {

        List<Student> students = new ArrayList<>();
        students.add(new Student(UUID.randomUUID(), "John Doe1"));
        students.add(new Student(UUID.randomUUID(), "John Doe2"));

        Lesson class_ = Lesson.builder().date(LocalDate.now()).build();

        Attendance attendance = new Attendance(class_, students.get(0), false);
        Attendance attendance1 = new Attendance(class_, students.get(1), true);

        List<Attendance> attendances = new ArrayList<>();
        attendances.add(attendance);
        attendances.add(attendance1);

        return attendances;
    }
}