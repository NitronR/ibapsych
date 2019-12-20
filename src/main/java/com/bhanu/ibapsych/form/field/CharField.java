package com.bhanu.ibapsych.form.field;

import com.bhanu.ibapsych.form.validator.RequiredValidator;

public class CharField extends FormField<String> {

    public CharField(String value) {
        super(value);
        validators.add(new RequiredValidator(true));
    }

    @Override
    protected String cleanValue(String value) {
        // by default clean value should not have boundary spaces
        return value.trim();
    }
    
}