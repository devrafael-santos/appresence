package com.raffasdev.appresence.identity.application.exception;

import com.raffasdev.appresence.shared.exception.ApplicationException;

public class EmailAlreadyExistsException extends ApplicationException {
    public EmailAlreadyExistsException(String value) {
        super("E-mail already exists: " + value);
    }
}
