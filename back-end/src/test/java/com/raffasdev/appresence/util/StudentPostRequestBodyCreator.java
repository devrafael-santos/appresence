package com.raffasdev.appresence.util;

import com.raffasdev.appresence.domain.Student;
import com.raffasdev.appresence.request.StudentPostRequestBody;

public class StudentPostRequestBodyCreator {

    public static StudentPostRequestBody createProductPostRequestBody() {
        Student student = StudentCreator.createValidStudent();

        return StudentPostRequestBody.builder().name(student.getName()).build();
    }
}
