package com.raffasdev.backend.mapper;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.request.StudentPostRequestBody;
import com.raffasdev.backend.request.StudentPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class StudentMapper {
    public static final StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    public abstract Student toStudent(StudentPostRequestBody studentPostRequestBody);

    public abstract Student toStudent(StudentPutRequestBody studentPutRequestBody);
}
