package com.raffasdev.appresence.identity.web.rest.controller;

import com.raffasdev.appresence.identity.application.service.StudentApplicationService;
import com.raffasdev.appresence.identity.web.rest.dto.request.StudentRequest;
import com.raffasdev.appresence.identity.web.rest.dto.response.StudentResponse;
import com.raffasdev.appresence.shared.swagger.CommonApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Students", description = "Endpoints for managing students")
@CommonApiResponse
@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentApplicationService service;

    public StudentController(StudentApplicationService service) {
        this.service = service;
    }

    @Operation(summary = "Student registration", description = "Make a registry of a student user", responses = {
            @ApiResponse(responseCode = "201", description = "Student successfully registered"),
    })
    @PostMapping("/auth/singup")
    public ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest request) {
        StudentResponse response = service.create(request);
        response.add(
                linkTo(methodOn(StudentController.class).create(request)).withSelfRel()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
