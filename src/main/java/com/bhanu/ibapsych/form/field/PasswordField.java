package com.bhanu.ibapsych.form.field;

import com.bhanu.ibapsych.form.validator.PasswordValidator;

public class PasswordField extends FormField<String> {

    public PasswordField(String password) {
        super(password);
        validators.add(new PasswordValidator());
    }
}