package com.raffasdev.backend.controller;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.request.StudentPostRequestBody;
import com.raffasdev.backend.service.StudentService;
import com.raffasdev.backend.util.StudentCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

}