package com.raffasdev.backend.util;

import com.raffasdev.backend.domain.Student;

import java.util.UUID;

public class StudentCreator {

    private static final UUID id = UUID.randomUUID();

    public static Student createValidStudent() {
        return Student.builder().id(id).name("Teste").build();
    }
}
