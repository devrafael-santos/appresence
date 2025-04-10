package com.raffasdev.backend.service;

import com.raffasdev.backend.domain.Student;
import com.raffasdev.backend.exception.BadRequestException;
import com.raffasdev.backend.mapper.StudentMapper;
import com.raffasdev.backend.repository.StudentRepository;
import com.raffasdev.backend.request.StudentPostRequestBody;
import com.raffasdev.backend.request.StudentPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student findByIdOrThrowBadRequestException(UUID uuid) {
        return studentRepository.findById(uuid)
                .orElseThrow(() -> new BadRequestException("Student not found"));
    }

    @Transactional
    public Student createStudent(StudentPostRequestBody studentPostRequestBody) {
        return studentRepository.save(StudentMapper.INSTANCE.toStudent(studentPostRequestBody));
    }

    @Transactional
    public void updateStudent(UUID uuid, StudentPutRequestBody studentPutRequestBody) {
        Student savedStudent = findByIdOrThrowBadRequestException(uuid);

        Student student = StudentMapper.INSTANCE.toStudent(studentPutRequestBody);
        student.setId(savedStudent.getId());

        studentRepository.save(student);
    }

    public void deleteStudent(UUID uuid) {
        Student student = findByIdOrThrowBadRequestException(uuid);

        studentRepository.delete(student);
    }

}
