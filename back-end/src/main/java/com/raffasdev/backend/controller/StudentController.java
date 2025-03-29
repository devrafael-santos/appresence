package com.raffasdev.backend.controller;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable UUID id) {

        return new ResponseEntity<>(studentService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
    }
}