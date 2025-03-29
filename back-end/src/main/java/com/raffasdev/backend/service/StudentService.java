package com.raffasdev.backend.service;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.exception.BadRequestException;
import com.raffasdev.backend.mapper.StudentMapper;
import com.raffasdev.backend.repository.StudentRepository;
import com.raffasdev.backend.request.StudentPostRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student findByIdOrThrowBadRequestException(UUID uuid) {
        return studentRepository.findById(uuid)
                .orElseThrow(() -> new BadRequestException("Student not found"));
    }

    @Transactional
    public Student createStudent(StudentPostRequestBody studentPostRequestBody) {
        return studentRepository.save(StudentMapper.INSTANCE.toStudent(studentPostRequestBody));
    }
}
