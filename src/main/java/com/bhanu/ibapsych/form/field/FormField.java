package com.bhanu.ibapsych.form.field;

import java.util.ArrayList;
import java.util.List;

import com.bhanu.ibapsych.form.exception.ValidationException;
import com.bhanu.ibapsych.form.validator.FieldValidator;

public class FormField<T> {
    T value;
    List<FieldValidator<T>> validators;

    public FormField(T value) {
        validators = new ArrayList<>();
        this.value = value;
    }

    public void addValidator(FieldValidator<T> validator) {
        validators.add(validator);
    }

    // apply all validators and return list of error messages
    public List<String> validate() {
        List<String> errorMsgs = new ArrayList<>();

        for (FieldValidator<T> validator : validators) {
            try {
                validator.validate(value);
            } catch (ValidationException e) {
                errorMsgs.add(e.getMessage());
            }
        }

        return errorMsgs;
    }

    protected T cleanValue(T value){
        return value;
    }

    public T getValue() {
        return cleanValue(value);
    }
}