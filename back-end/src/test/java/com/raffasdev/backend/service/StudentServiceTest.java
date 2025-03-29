package com.raffasdev.backend.service;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.exception.BadRequestException;
import com.raffasdev.backend.repository.StudentRepository;
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

import java.util.Optional;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        BDDMockito.when(studentRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(StudentCreator.createValidStudent()));
    }

    @Test
    @DisplayName("findByIdOrThrowBadRequestException returns a Student when successful")
    public void findByIdOrThrowBadRequestException_ReturnsStudent_WhenSuccessful() {
        UUID expectedId = StudentCreator.createValidStudent().getId();

        Student foundStudent = studentService.findByIdOrThrowBadRequestException(UUID.randomUUID());

        Assertions.assertThat(foundStudent).isNotNull();
        Assertions.assertThat(foundStudent.getId()).isEqualTo(expectedId);
    }

    @Test
    @DisplayName("findByIdOrThrowBadRequestException throws BadRequestException when Student is not found")
    public void findByIdOrThrowBadRequestException_ThrowsBadRequestException_WhenStudentIsNotFound() {
        BDDMockito.when(studentRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> studentService.findByIdOrThrowBadRequestException(UUID.randomUUID()))
                .isInstanceOf(BadRequestException.class);
    }

}