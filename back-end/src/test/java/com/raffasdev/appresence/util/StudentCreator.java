package com.raffasdev.appresence.util;

import com.raffasdev.appresence.domain.Student;

import java.util.UUID;

public class StudentCreator {

    private static final UUID id = UUID.randomUUID();

    public static Student createValidStudent() {
        return Student.builder().id(id).name("Teste").build();
    }

    public static Student createValidStudentToBeSaved() {
        return Student.builder().name("Teste").build();
    }
}
