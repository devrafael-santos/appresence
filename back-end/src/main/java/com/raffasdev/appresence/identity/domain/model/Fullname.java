package com.raffasdev.appresence.identity.domain.model;

import com.raffasdev.appresence.identity.domain.exception.InvalidNameException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Fullname extends ValueObject {
    private final String firstName;
    private final String lastName;

    private Fullname(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        validate();
    }

    public static Fullname newFullname(String fristName, String lastName) {
        return new Fullname(fristName, lastName);
    }

    protected String value() {
        return String.format("%s %s", firstName, lastName);
    }

    public static Fullname from(String fullName) {
        String[] name = fullName.split(" ");
        String firstName = name[0];
        String lastName = "";

        if(name.length > 1) {
            lastName = Arrays.stream(name)
                    .skip(1)
                    .collect(Collectors.joining(" "));
        }

        return new Fullname(firstName, lastName);
    }

    private void validate() {
        if (firstName == null || firstName.isBlank()) {
            throw new InvalidNameException(firstName);
        }
        if (lastName == null || lastName.isBlank()) {
            throw new InvalidNameException(lastName);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fullname)) return false;
        Fullname fullname = (Fullname) o;
        return firstName.equals(fullname.firstName) && lastName.equals(fullname.lastName);
    }

    @Override
    public int hashCode() {
        return (31 * firstName.hashCode()) + (31 * lastName.hashCode());
    }
}
