package com.example.user_service.validator;

import com.example.user_service.util.UtilForEmail;
import com.example.user_service.validator.annotation.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public void initialize(Email checkEmail) {
    }

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext cxt) {
        if (email != null) {
            return UtilForEmail.checkEmail(email);
        }
        return false;
    }
}
