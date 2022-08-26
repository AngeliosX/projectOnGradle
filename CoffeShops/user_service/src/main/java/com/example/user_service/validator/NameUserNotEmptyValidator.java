package com.example.user_service.validator;

import com.example.user_service.util.UtilForUserName;
import com.example.user_service.validator.annotation.NameUserNotEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameUserNotEmptyValidator implements ConstraintValidator<NameUserNotEmpty, String> {

    @Override
    public void initialize(NameUserNotEmpty nameUserNotEmpty) {
    }

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext cxt) {
        if(userName != null) {
            return UtilForUserName.checkUserName(userName);
        }
        return false;
    }

}