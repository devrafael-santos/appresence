package com.raffasdev.appresence.identity.web.rest.dto.response;

import com.raffasdev.appresence.identity.web.rest.validator.PasswordsMatch;
import org.springframework.hateoas.RepresentationModel;

public class PersonResponse extends RepresentationModel<PersonResponse> {

    private String id;
    private String fullName;
    private String email;
    private String phone;

    public PersonResponse(String id, String fullName, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
