package com.raffasdev.backend.util;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.request.StudentPostRequestBody;

public class StudentPostRequestBodyCreator {

    public static StudentPostRequestBody createProductPostRequestBody() {
        Student student = StudentCreator.createValidStudent();

        return StudentPostRequestBody.builder().name(student.getName()).build();
    }
}
