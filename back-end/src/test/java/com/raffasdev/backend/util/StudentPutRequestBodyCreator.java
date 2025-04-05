package com.raffasdev.backend.util;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.request.StudentPutRequestBody;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentPutRequestBodyCreator {

    public static StudentPutRequestBody createStudentPutRequestBody() {
        Student student = StudentCreator.createValidStudent();

        return StudentPutRequestBody.builder().name(student.getName()).build();
    }

}
