package com.example.DemoSpringBoot.validationz;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// ConstraintValidator<ConstrainInterface,type of input to validated>
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {

    @Override
    public void initialize(PhoneNumberConstraint phoneNumber) {
    }

    @Override
    public boolean isValid(String phoneNumberField, ConstraintValidatorContext context) {
        if (phoneNumberField != null
                && phoneNumberField.matches("[0-9]+")
                && phoneNumberField.length() >= 8
                && phoneNumberField.length() <= 10) {
            return true;
        }
        return false;
    }

}
