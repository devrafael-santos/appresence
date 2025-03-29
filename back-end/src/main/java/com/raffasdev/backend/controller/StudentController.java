package com.raffasdev.backend.controller;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.request.StudentPostRequestBody;
import com.raffasdev.backend.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentPostRequestBody studentPostRequestBody) {
        return new ResponseEntity<>(studentService.createStudent(studentPostRequestBody), HttpStatus.CREATED);
    }
}