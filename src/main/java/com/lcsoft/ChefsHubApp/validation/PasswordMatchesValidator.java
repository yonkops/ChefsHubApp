package com.lcsoft.ChefsHubApp.validation;

import com.lcsoft.ChefsHubApp.model.dto.UserRegistrationDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        UserRegistrationDto user = (UserRegistrationDto) value;
        return user.password().equals(user.confirmPassword());
    }
}
