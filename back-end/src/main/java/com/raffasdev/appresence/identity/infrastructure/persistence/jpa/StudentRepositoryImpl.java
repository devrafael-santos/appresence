package com.raffasdev.appresence.identity.infrastructure.persistence.jpa;

import com.raffasdev.appresence.identity.infrastructure.persistence.entity.StudentEntity;
import com.raffasdev.appresence.identity.domain.repository.StudentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final StudentJpaRepository jpaRepository;

    public StudentRepositoryImpl(StudentJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public StudentEntity save(StudentEntity entity) {
        return jpaRepository.save(entity);
    }

    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }
}
