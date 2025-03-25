package com.raffasdev.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/students")
public class StudentController {

    @GetMapping()
    public String getStudents() { 
        return "Hello World";
    }
}
