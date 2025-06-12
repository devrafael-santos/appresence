package com.raffasdev.appresence.identity.web.rest.dto.request;

import com.raffasdev.appresence.identity.web.rest.validator.PasswordsMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.hateoas.RepresentationModel;

@PasswordsMatch
public class PersonRequest extends RepresentationModel<PersonRequest> {
    @NotBlank(message = "First name is required.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    private String lastName;

    @Email(message = "E-mail must be valid.")
    @NotBlank(message = "E-mail is required.")
    private String email;

    @NotBlank(message = "Phone is required.")
    private String phone;

    @NotBlank(message = "Password is required.")
    private String password;

    @NotBlank(message = "Password confirmation is required.")
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public PersonRequest(String firstname, String lastname, String email, String phone, String password,
                         String confirmPassword) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
