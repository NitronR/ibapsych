package com.bhanu.ibapsych.form.validator;

import com.bhanu.ibapsych.form.exception.ValidationException;

public class PasswordValidator implements FieldValidator {

    @Override
    public void validate(String value) throws ValidationException {
        // TODO throw exception if password constraints not matched
        if (value.length() < 8) {
            throw new ValidationException("Password must have atleast 8 characters.");
        }
    }

}