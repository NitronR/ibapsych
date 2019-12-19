package com.bhanu.ibapsych.form.validator;

import com.bhanu.ibapsych.form.exception.ValidationException;

public interface FieldValidator{
    public void validate(String value) throws ValidationException;
}