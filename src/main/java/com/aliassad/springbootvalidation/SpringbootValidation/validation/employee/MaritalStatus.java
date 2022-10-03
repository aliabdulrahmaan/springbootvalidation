package com.aliassad.springbootvalidation.SpringbootValidation.validation.employee;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MaritalStatusValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MaritalStatus {
    String message() default "Invalid marital status input";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}