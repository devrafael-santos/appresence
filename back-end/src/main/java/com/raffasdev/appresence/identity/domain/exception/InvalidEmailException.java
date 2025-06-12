package com.raffasdev.appresence.identity.domain.exception;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super("Invalid e-mail: " + message);
    }
}
