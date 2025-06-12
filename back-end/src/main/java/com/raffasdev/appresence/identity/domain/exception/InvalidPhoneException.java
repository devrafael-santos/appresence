package com.raffasdev.appresence.identity.domain.exception;

public class InvalidPhoneException extends RuntimeException {
    public InvalidPhoneException(String message) {
        super("Invalid phone: " + message);
    }
}
