package com.bhanu.ibapsych.form.validator;

import com.bhanu.ibapsych.form.exception.ValidationException;

public interface FieldValidator<T>{
    public void validate(T value) throws ValidationException;
}