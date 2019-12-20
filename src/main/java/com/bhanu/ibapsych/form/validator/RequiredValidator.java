package com.bhanu.ibapsych.form.validator;

import com.bhanu.ibapsych.form.exception.ValidationException;

public class RequiredValidator implements FieldValidator<String> {
    private boolean trim;

    public RequiredValidator(boolean trim) {
        this.trim = trim;
    }

    @Override
    public void validate(String value) throws ValidationException {
        if (trim)
            value = value.trim();
        if (value.equals("")) {
            throw new ValidationException("This field should not be empty.");
        }
    }

}