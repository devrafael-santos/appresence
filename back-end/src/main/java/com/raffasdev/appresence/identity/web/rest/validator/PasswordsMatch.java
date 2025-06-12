package com.raffasdev.appresence.identity.web.rest.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordsMatchValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordsMatch {
    String message() default "Password and confirmation do not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
