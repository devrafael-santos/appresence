package com.raffasdev.appresence.shared.exception;

public enum ErrorCode {
    INVALID_CREDENTIALS("INVALID_CREDENTIALS"),
    RESOURCE_NOT_FOUND("RESOURCE_NOT_FOUND"),
    VALIDATION_ERROR("VALIDATION_ERROR"),
    CONFLICT_ERROR("CONFLICT_ERROR"),
    DOMAIN_ERROR("DOMAIN_ERROR"),
    INTERNAL_ERROR("INTERNAL_ERROR");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
