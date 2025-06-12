package com.raffasdev.appresence.identity.domain.model;

import java.time.Instant;

public abstract class Person extends Entity<EntityId> {

    private final Fullname name;
    private final Email email;
    private final Phone phone;
    private final String hashedPassword;

    protected Person(EntityId id, Fullname name, Email email, Phone phone, String hashedPassword) {
        super(id);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.hashedPassword = hashedPassword;
    }

    public boolean hasEmail(String email) {
        return this.email.value().equalsIgnoreCase(email);
    }

    public boolean hasName(String name) {
        return this.name.value().equalsIgnoreCase(name);
    }

    public boolean hasPhone(String phone) {
        return this.phone.value().equalsIgnoreCase(phone);
    }

    public boolean hasHashedPassword(String hashedPassword) {
        return this.hashedPassword.equals(hashedPassword);
    }

    public boolean hasCreatedAt(Instant createdAt) {
        return createdAt.equals(createdAt);
    }

    public boolean hasUpdatedAt(Instant updatedAt) {
        return updatedAt.equals(updatedAt);
    }

    public String getName() {
        return this.name.value();
    }

    public String getEmail() {
        return this.email.value();
    }

    public String getPhone() {
        return this.phone.value();
    }

    public String getHashedPassword() {
        return this.hashedPassword;
    }
}
