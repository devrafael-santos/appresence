package com.raffasdev.appresence.identity.domain.model;

import com.raffasdev.appresence.identity.domain.exception.InvalidEmailException;

import java.util.regex.Pattern;

public class Email extends ValueObject {
    private final String email;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("[\\w-.]+@[\\w-]+\\.[a-z]{2,}$",
            Pattern.CASE_INSENSITIVE);

    private Email(String email) {
        this.email = email;
        validate();
    }

    public String value() {
        return email;
    }

    public static Email newEmail(String email) {
        return new Email(email);
    }

    public static Email from(String email) {
        return new Email(email);
    }

    private void validate() {
        if (email == null || email.isBlank()) {
            throw new InvalidEmailException(email);
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidEmailException(email);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email1 = (Email) o;
        return email.equals(email1.email);
    }

    @Override
    public int hashCode() {
        return 31 + (email != null ? email.hashCode() : 0);
    }
}
