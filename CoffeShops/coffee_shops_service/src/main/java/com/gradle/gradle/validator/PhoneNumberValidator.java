package com.gradle.gradle.validator;

import com.gradle.gradle.util.UtilForPhoneNumber;
import com.gradle.gradle.validator.annotation.PhoneNumberConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements
        ConstraintValidator<PhoneNumberConstraint, String> {

    @Override
    public void initialize(PhoneNumberConstraint contactNumber) {
    }

    @Override
    public boolean isValid(String phone,
                           ConstraintValidatorContext cxt) {
        if(phone != null) {
            return UtilForPhoneNumber.checkRuPhone(phone);
        }
        return false;
    }

}