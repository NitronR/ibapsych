package com.bhanu.ibapsych.form.validator;

import javax.validation.ValidationException;

import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

public class EmailFieldValidator implements FieldValidator<String> {

    @Override
    public void validate(String email) {
        // Throw exception if email is not valid
        EmailValidator emailValidator = new EmailValidator();
        if(!emailValidator.isValid(email, null)){
            throw new ValidationException("Email not valid.");
        }
    }

}