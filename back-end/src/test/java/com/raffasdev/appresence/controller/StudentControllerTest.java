package com.raffasdev.appresence.controller;

import com.raffasdev.appresence.domain.Student;
import com.raffasdev.appresence.request.StudentPostRequestBody;
import com.raffasdev.appresence.service.StudentService;
import com.raffasdev.appresence.util.StudentCreator;
import com.raffasdev.appresence.util.StudentPostRequestBodyCreator;
import com.raffasdev.appresence.util.StudentPutRequestBodyCreator;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        PageImpl<Student> studentPage = new PageImpl<>(List.of(StudentCreator.createValidStudent()));

        BDDMockito.when(studentService.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(studentPage);

        BDDMockito.when(studentService.createStudent(ArgumentMatchers.any(StudentPostRequestBody.class)))
                .thenReturn(StudentCreator.createValidStudent());

        BDDMockito.when(studentService.findByIdOrThrowBadRequestException(ArgumentMatchers.any()))
                .thenReturn(StudentCreator.createValidStudent());
    }

    @Test
    @DisplayName("findAll returns a Page Object of Students when successful")
    void findAll_ReturnsPageObjectOfStudents_WhenSuccessful() {
        String expectedName = StudentCreator.createValidStudent().getName();

        Page<Student> studentPage = studentController.findAll(PageRequest.of(1, 1)).getBody();

        Assertions.assertThat(studentPage).isNotNull();
        Assertions.assertThat(studentPage.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(studentPage.toList().get(0).getName()).isEqualTo(expectedName);
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
    @DisplayName("updateStudent updates a Student when successful")
    void updateStudent_UpdatesStudent_WhenSuccessful() {
        ResponseEntity<Void> entity = studentController.updateStudent(UUID.randomUUID(),
                StudentPutRequestBodyCreator.createStudentPutRequestBody());

        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("deleteStudent deletes a Student when successful")
    void deleteStudent_DeleteStudent_WhenSuccessful() {
        ResponseEntity<Void> entity = studentController.deleteStudent(UUID.randomUUID());

        Assertions.assertThat(entity).isNotNull();
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

}