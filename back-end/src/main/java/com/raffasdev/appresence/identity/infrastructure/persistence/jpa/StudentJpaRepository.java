package com.raffasdev.appresence.identity.infrastructure.persistence.jpa;

import com.raffasdev.appresence.identity.infrastructure.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, UUID> {
    boolean existsByEmail(String email);
}
