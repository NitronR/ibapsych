package com.bhanu.ibapsych.form.field;

import com.bhanu.ibapsych.form.validator.EmailFieldValidator;

public class EmailField extends CharField {
    String email;

    public EmailField(String email) {
        super(email);

        validators.add(new EmailFieldValidator());
    }
}