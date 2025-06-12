package com.raffasdev.appresence.identity.infrastructure.persistence.mapper;

import com.raffasdev.appresence.identity.infrastructure.persistence.entity.StudentEntity;
import com.raffasdev.appresence.identity.domain.model.*;

public class StudentMapper {

    public static StudentEntity toEntity(Student student) {
        return StudentEntity.create(
                student.getId().value(),
                student.getName(),
                student.getEmail(),
                student.getPhone(),
                student.getHashedPassword());
    }

    public static Student toDomain(StudentEntity entity) {
        return Student.create(
                EntityId.from(entity.getId()),
                Fullname.from(entity.getName()),
                Email.from(entity.getEmail()),
                Phone.from(entity.getPhone()),
                entity.getPassword());
    }
}
