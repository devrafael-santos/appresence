package com.raffasdev.appresence.identity.domain.model;

import com.raffasdev.appresence.identity.domain.exception.InvalidPhoneException;

import java.util.regex.Pattern;

public class Phone extends ValueObject {

    private final String phone;

    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{3}\\d{4}\\d{4}$");

    public Phone(String phone) {
        this.phone = phone;
        validate();
    }

    public String value() {
        return phone;
    }

    public static Phone newPhone(String phone) {
        return new Phone(phone);
    }

    public static Phone from(String phone) {
        return new Phone(phone);
    }

    private void validate() {
        if (phone == null || phone.isEmpty()) {
            throw new InvalidPhoneException(phone);
        }
        if (!PHONE_PATTERN.matcher(phone).matches()) {
            throw new InvalidPhoneException(phone);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return phone.equals(phone.phone);
    }

    @Override
    public int hashCode() {
        return 31 + (phone != null ? phone.hashCode() : 0);
    }
}
