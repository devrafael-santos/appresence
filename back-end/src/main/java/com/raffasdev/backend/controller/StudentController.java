package com.raffasdev.backend.controller;

import com.raffasdev.backend.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/students")
public class StudentController {

    @GetMapping()
    public List<Student> getStudents() {

        List<Student> students = new ArrayList<>();
        students.add(new Student(UUID.randomUUID(), "John Doe1"));
        students.add(new Student(UUID.randomUUID(), "John Doe2"));

        return students;
    }
}
