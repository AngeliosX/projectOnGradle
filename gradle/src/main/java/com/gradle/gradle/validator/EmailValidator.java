package com.gradle.gradle.validator;

import com.gradle.gradle.util.UtilForEmail;
import com.gradle.gradle.validator.annotation.EmailConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {
    @Override
    public void initialize(EmailConstraint checkEmail) {
    }

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext cxt) {
        if(email != null) {
            return UtilForEmail.checkEmail(email);
        }
        return false;
    }
}
