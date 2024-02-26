package com.kamikase.web.api.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameValidation, String> {

    private String message;

    @Override
    public void initialize(NameValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        if (nome.contains("Flamengo") || nome.contains("Palmeiras") || nome.contains("Fluminense") || nome.contains("Botafogo")) {
          constraintValidatorContext.disableDefaultConstraintViolation();
          constraintValidatorContext
                  .buildConstraintViolationWithTemplate(message + nome)//
                  .addConstraintViolation();
          return false;
        }
        return true;
    }
  
}
