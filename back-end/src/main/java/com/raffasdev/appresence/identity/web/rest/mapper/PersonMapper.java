package com.raffasdev.appresence.identity.web.rest.mapper;

import com.raffasdev.appresence.identity.infrastructure.persistence.entity.StudentEntity;
import com.raffasdev.appresence.identity.web.rest.dto.response.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public StudentResponse toResponse(StudentEntity student) {
        return new StudentResponse(
                student.getId().toString(),
                student.getName(),
                student.getEmail(),
                student.getPhone()
        );
    }
}
