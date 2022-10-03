package com.aliassad.springbootvalidation.SpringbootValidation.validation.employee;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaritalStatusValidator  implements ConstraintValidator<MaritalStatus, String> {
    @Override
    public void initialize(MaritalStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s!=null && s.equalsIgnoreCase("Single") || s.equalsIgnoreCase("Married") ;
    }
}
