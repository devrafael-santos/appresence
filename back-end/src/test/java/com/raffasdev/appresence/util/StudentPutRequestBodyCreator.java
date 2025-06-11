package com.raffasdev.appresence.util;

import com.raffasdev.appresence.domain.Student;
import com.raffasdev.appresence.request.StudentPutRequestBody;
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
