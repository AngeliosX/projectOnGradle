package com.example.user_service.validator.annotation;

import com.example.user_service.validator.NameUserNotEmptyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameUserNotEmptyValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NameUserNotEmpty {
    String message() default "The name of the user is empty, please check it.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
