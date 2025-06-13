package com.raffasdev.appresence.identity.domain.service;

public interface PasswordHasher {

    String hash(String password);

    boolean matches(CharSequence rawPassword, String hashedPassword);
}
