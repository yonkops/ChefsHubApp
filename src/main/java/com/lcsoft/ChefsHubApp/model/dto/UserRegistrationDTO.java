package com.lcsoft.ChefsHubApp.model.dto;


import com.lcsoft.ChefsHubApp.validation.FieldMatch;
import com.lcsoft.ChefsHubApp.validation.PasswordMatches;
import com.lcsoft.ChefsHubApp.validation.UniqueUserEmail;
import jakarta.validation.constraints.*;


@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords should match."
)
public record UserRegistrationDTO(@NotEmpty(message = "First Name is required")
                                  @Size(min = 3, max = 30)
                                  String firstName,
                                  @NotEmpty(message = "Last Name is required")
                                  @Size(min = 3, max = 30)
                                  String lastName,
                                  @NotNull(message = "Email is required")
                                  @Email
                                  @UniqueUserEmail String email,
                                  @Size(min = 6, message = "Password must be at least 6 characters")
                                  @NotEmpty(message = "Password is required")
                                  String password,
                                  @NotEmpty
                                  String confirmPassword) {
}
