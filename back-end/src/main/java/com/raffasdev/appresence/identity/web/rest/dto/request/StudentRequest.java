package com.raffasdev.appresence.identity.web.rest.dto.request;

public class StudentRequest extends PersonRequest {

    public StudentRequest(String firstName, String lastName, String email, String phone, String password, String confirmPassword) {
        super(firstName, lastName, email, phone, password, confirmPassword);
    }
}
