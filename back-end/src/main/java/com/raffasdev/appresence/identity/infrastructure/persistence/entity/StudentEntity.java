package com.raffasdev.appresence.identity.infrastructure.persistence.entity;

import com.raffasdev.appresence.shared.infrastructure.persistence.entity.BaseJpaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "students")
public class StudentEntity extends BaseJpaEntity {

    @Id
    @Column(name = "student_id")
    private UUID studentId;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    private StudentEntity(UUID id, String name, String email, String phone, String password) {
        this.studentId = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public static StudentEntity create(UUID id, String name, String email, String phone, String password) {
        return new StudentEntity(id, name, email, phone, password);
    }

    public StudentEntity() {
    }

    public UUID getId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
