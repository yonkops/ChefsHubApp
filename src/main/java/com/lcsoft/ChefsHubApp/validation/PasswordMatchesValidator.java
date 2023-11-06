package com.lcsoft.ChefsHubApp.validation;

import com.lcsoft.ChefsHubApp.model.dto.UserRegistrationDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        UserRegistrationDTO user = (UserRegistrationDTO) value;
        return user.password().equals(user.confirmPassword());
    }
}
