package com.raffasdev.appresence.identity.web.rest.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Method;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, Object> {

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Method getPassword = o.getClass().getMethod("getPassword");
            Method getConfirmPassword = o.getClass().getMethod("getConfirmPassword");

            String password = (String) getPassword.invoke(o);
            String confirmPassword = (String) getConfirmPassword.invoke(o);

            if(password == null || confirmPassword == null) {
                return false;
            }

            return password.equals(confirmPassword);
        } catch (Exception e) {
            return false;
        }
    }
}
