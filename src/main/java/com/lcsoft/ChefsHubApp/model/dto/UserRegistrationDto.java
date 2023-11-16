package com.lcsoft.ChefsHubApp.model.dto;


import com.lcsoft.ChefsHubApp.validation.FieldMatch;
import com.lcsoft.ChefsHubApp.validation.UniqueUserEmail;
import jakarta.validation.constraints.*;

import java.util.Objects;


@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords should match."
)
public class UserRegistrationDto {
    private @NotEmpty(message = "First Name is required") @Size(min = 3, max = 30) String firstName;
    private @NotEmpty(message = "Last Name is required") @Size(min = 3, max = 30) String lastName;
    @UniqueUserEmail
    private @NotNull(message = "Email is required") @Email String email;
    private @Size(min = 6, message = "Password must be at least 6 characters") @NotEmpty(message = "Password is required") String password;
    private @NotEmpty String confirmPassword;

    public UserRegistrationDto() {}

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}

