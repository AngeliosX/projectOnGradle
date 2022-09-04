package com.example.user_service.validator.annotation;

import com.example.user_service.validator.CheckEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckEmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    String message() default "The email not correct format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
