package com.raffasdev.appresence.identity.infrastructure.security;

import com.raffasdev.appresence.identity.domain.service.PasswordHasher;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptPasswordHasher implements PasswordHasher {
    private final PasswordEncoder encoder;

    public BCryptPasswordHasher(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String hash(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }
}
