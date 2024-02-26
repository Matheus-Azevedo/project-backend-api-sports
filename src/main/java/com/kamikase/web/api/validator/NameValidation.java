package com.kamikase.web.api.validator;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NameValidator.class)
public @interface NameValidation {
    String message() default "Nome não é válido, tem outro";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
  
}
