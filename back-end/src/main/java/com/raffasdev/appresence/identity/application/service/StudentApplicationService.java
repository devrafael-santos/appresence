package com.raffasdev.appresence.identity.application.service;

import com.raffasdev.appresence.identity.application.exception.EmailAlreadyExistsException;
import com.raffasdev.appresence.identity.domain.model.*;
import com.raffasdev.appresence.identity.domain.repository.StudentRepository;
import com.raffasdev.appresence.identity.domain.service.PasswordHasher;
import com.raffasdev.appresence.identity.infrastructure.persistence.entity.StudentEntity;
import com.raffasdev.appresence.identity.infrastructure.persistence.mapper.StudentMapper;
import com.raffasdev.appresence.identity.web.rest.dto.request.StudentRequest;
import com.raffasdev.appresence.identity.web.rest.dto.response.StudentResponse;
import com.raffasdev.appresence.identity.web.rest.mapper.PersonMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentApplicationService {

    private final PasswordHasher passwordHasher;
    private final StudentRepository repository;
    private final PersonMapper personMapper;

    public StudentApplicationService(PasswordHasher passwordHasher, StudentRepository repository, PersonMapper personMapper) {
        this.passwordHasher = passwordHasher;
        this.repository = repository;
        this.personMapper = personMapper;
    }

    public StudentResponse create(StudentRequest input) {
        boolean studentAlreadyExists = repository.existsByEmail(input.getEmail());

        if (studentAlreadyExists) {
            throw new EmailAlreadyExistsException(input.getEmail());
        }

        EntityId id = EntityId.newIdentifier();
        Fullname name = Fullname.newFullname(input.getFirstName(), input.getLastName());
        Email email = Email.newEmail(input.getEmail());
        Phone phone = Phone.newPhone(input.getPhone());
        String hashedPassword = passwordHasher.hash(input.getPassword());

        Student student = Student.create(id, name, email, phone, hashedPassword);
        StudentEntity studentEntity = StudentMapper.toEntity(student);

        StudentEntity savedStudentEntity = repository.save(studentEntity);

        return personMapper.toResponse(savedStudentEntity);
    }
}
