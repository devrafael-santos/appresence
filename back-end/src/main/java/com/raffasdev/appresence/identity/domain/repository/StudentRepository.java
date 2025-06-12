package com.raffasdev.appresence.identity.domain.repository;

import com.raffasdev.appresence.identity.infrastructure.persistence.entity.StudentEntity;

public interface StudentRepository {
    StudentEntity save(StudentEntity student);

    boolean existsByEmail(String email);
}
