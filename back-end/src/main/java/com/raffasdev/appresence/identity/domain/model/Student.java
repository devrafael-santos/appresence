package com.raffasdev.appresence.identity.domain.model;

public class Student extends Person {

    private Student(EntityId id, Fullname name, Email email, Phone phone, String hashedPassword) {
        super(id, name, email, phone, hashedPassword);
    }

    public static Student create(EntityId id, Fullname name, Email email, Phone phone, String hashedPassword) {
        return new Student(id, name, email, phone, hashedPassword);
    }
}
