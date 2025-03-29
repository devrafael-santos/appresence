package com.raffasdev.backend.util;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.request.StudentPostRequestBody;

public class StudentPostRequestBodyCreator {

    public static StudentPostRequestBody createValidStudentPostRequestBody() {
        return StudentPostRequestBody.builder().name("Teste1").build();
    }
}
