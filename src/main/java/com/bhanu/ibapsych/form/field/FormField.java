package com.bhanu.ibapsych.form.field;

import java.util.ArrayList;
import java.util.List;

import com.bhanu.ibapsych.form.exception.ValidationException;
import com.bhanu.ibapsych.form.validator.FieldValidator;

public class FormField {
    String value;
    List<FieldValidator> validators;

    public FormField(String value) {
        validators = new ArrayList<>();
        this.value = value;
    }

    public void addValidator(FieldValidator validator) {
        validators.add(validator);
    }

    // apply all validators and return list of error messages
    public List<String> validate() {
        List<String> errorMsgs = new ArrayList<>();

        for (FieldValidator validator : validators) {
            try {
                validator.validate(value);
            } catch (ValidationException e) {
                errorMsgs.add(e.getMessage());
            }
        }

        return errorMsgs;
    }

    protected String cleanValue(String value){
        return value;
    }

    public String getValue() {
        return cleanValue(value);
    }
}