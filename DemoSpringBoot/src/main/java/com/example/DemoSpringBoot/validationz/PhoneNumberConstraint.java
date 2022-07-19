package com.example.DemoSpringBoot.validationz;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// can be used by any other classes in project
@Documented
// Class going to validate the field
@Constraint(validatedBy = PhoneNumberValidator.class)
// where can you put this annotation on
@Target({ElementType.METHOD, ElementType.FIELD})
// 
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberConstraint {
    String message() default "Not the right phone number";
    // boilerplate
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
