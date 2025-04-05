package com.raffasdev.backend.service;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.exception.BadRequestException;
import com.raffasdev.backend.repository.StudentRepository;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        PageImpl<Student> studentPage = new PageImpl<>(List.of(StudentCreator.createValidStudent()));

        BDDMockito.when(studentRepository.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(studentPage);

        BDDMockito.when(studentRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.of(StudentCreator.createValidStudent()));

        BDDMockito.when(studentRepository.save(ArgumentMatchers.any(Student.class)))
                .thenReturn(StudentCreator.createValidStudent());
    }

    @Test
    @DisplayName("findAll returns a Page Object of Students when successful")
    void findAll_ReturnsPageObjectOfStudents_WhenSuccessful() {
        String expectedName = StudentCreator.createValidStudent().getName();

        Page<Student> studentPage = studentService.findAll(PageRequest.of(1, 1));

        Assertions.assertThat(studentPage).isNotNull();
        Assertions.assertThat(studentPage.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(studentPage.toList().get(0).getName()).isEqualTo(expectedName);
    }

    @Test
    @DisplayName("findByIdOrThrowBadRequestException returns a Student when successful")
    void findByIdOrThrowBadRequestException_ReturnsStudent_WhenSuccessful() {
        UUID expectedId = StudentCreator.createValidStudent().getId();

        Student foundStudent = studentService.findByIdOrThrowBadRequestException(UUID.randomUUID());

        Assertions.assertThat(foundStudent).isNotNull();
        Assertions.assertThat(foundStudent.getId()).isEqualTo(expectedId);
    }

    @Test
    @DisplayName("findByIdOrThrowBadRequestException throws BadRequestException when Student is not found")
    void findByIdOrThrowBadRequestException_ThrowsBadRequestException_WhenStudentIsNotFound() {
        BDDMockito.when(studentRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> studentService.findByIdOrThrowBadRequestException(UUID.randomUUID()))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    @DisplayName("createStudent creates a Student when successful")
    void createStudent_CreatesStudent_WhenSuccessful() {
        Student student = studentService.createStudent(StudentPostRequestBodyCreator.createProductPostRequestBody());

        Assertions.assertThat(student).isNotNull().isEqualTo(StudentCreator.createValidStudent());
    }

    @Test
    @DisplayName("updateStudent updates a Student when successful")
    void updateStudent_UpdatesStudent_WhenSuccessful() {
        Assertions.assertThatCode(() -> studentService.updateStudent(UUID.randomUUID(),
                        StudentPutRequestBodyCreator.createStudentPutRequestBody()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("updateStudent throws BadRequestException when Student is not found")
    void updateStudent_ThrowsBadRequestException_WhenStudentIsNotFound() {
        BDDMockito.when(studentRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> studentService.updateStudent(UUID.randomUUID(),
                        StudentPutRequestBodyCreator.createStudentPutRequestBody()))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    @DisplayName("deleteStudent deletes Student when successful")
    void deleteStudent_DeleteStudent_WhenSuccessful() {
        Assertions.assertThatCode(() -> studentService.deleteStudent(UUID.randomUUID()))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("deleteStudent throws BadRequestException when Student is not found")
    void deleteStudent_ThrowsBadRequestException_WhenStudentIsNotFound() {
        BDDMockito.when(studentRepository.findById(ArgumentMatchers.any()))
                .thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> studentService.deleteStudent(UUID.randomUUID()))
                .isInstanceOf(BadRequestException.class);
    }


}