package com.kamikase.web.api.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailValidation {
    String message() default "Email não é válido tente matheus.br ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
