package com.raffasdev.backend.controller;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.request.StudentPostRequestBody;
import com.raffasdev.backend.service.StudentService;
import com.raffasdev.backend.util.StudentCreator;
import com.raffasdev.backend.util.StudentPostRequestBodyCreator;
import com.raffasdev.backend.util.StudentPutRequestBodyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

@ExtendWith(SpringExtension.class)
class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        BDDMockito.when(studentService.createStudent(ArgumentMatchers.any(StudentPostRequestBody.class)))
                .thenReturn(StudentCreator.createValidStudent());

        BDDMockito.when(studentService.findByIdOrThrowBadRequestException(ArgumentMatchers.any()))
                .thenReturn(StudentCreator.createValidStudent());
    }

    @Test
    @DisplayName("findById returns a Student when successful")
    void findById_ReturnsStudent_WhenSuccessful() {
        UUID expectedId = StudentCreator.createValidStudent().getId();

        Student student = studentController.findById(UUID.randomUUID()).getBody();

        Assertions.assertThat(student).isNotNull();

        Assertions.assertThat(student.getId()).isNotNull().isEqualTo(expectedId);
    }

    @Test
    @DisplayName("createStudent returns a Student when successful")
    void createStudent_ReturnsStudent_WhenSuccessful() {

        Student student = studentController.createStudent(StudentPostRequestBodyCreator.createProductPostRequestBody()).getBody();

        Assertions.assertThat(student).isNotNull();

        Assertions.assertThat(student.getName()).isNotNull().isEqualTo(StudentCreator.createValidStudent().getName());
    }

    @Test
    @DisplayName("updateStudent updates a Student when succesfull")
    void updateStudent_UpdatesStudent_WhenSuccessful() {
        ResponseEntity<Void> entity = studentController.updateStudent(UUID.randomUUID(),
                StudentPutRequestBodyCreator.createStudentPutRequestBody());

        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

}