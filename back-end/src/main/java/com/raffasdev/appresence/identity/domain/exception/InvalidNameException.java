package com.raffasdev.appresence.identity.domain.exception;

public class InvalidNameException extends RuntimeException {

    public InvalidNameException(String value) {
        super("Invalid name: " + value);
    }
}
