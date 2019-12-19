package com.bhanu.ibapsych.form;

import com.bhanu.ibapsych.form.exception.FieldDoNotExistException;
import com.bhanu.ibapsych.form.exception.FieldExistsException;
import com.bhanu.ibapsych.form.field.CharField;
import com.bhanu.ibapsych.form.field.EmailField;
import com.bhanu.ibapsych.form.field.PasswordField;
import com.bhanu.ibapsych.form.validator.FieldValidator;
import com.bhanu.ibapsych.model.user.Player;

public class PlayerRegForm extends Form {
    public PlayerRegForm(String email, String username, String password) throws FieldExistsException {
        EmailField emailField = new EmailField(email);

        // Email field unique validator
        emailField.addValidator(new FieldValidator() {
            @Override
            public void validate(String value) {
                // TODO throw error if already exist
            }
        });

        addField("email", emailField);

        CharField usernameField = new CharField(username);

        usernameField.addValidator(new FieldValidator() {
            public void validate(String username) {
                // TODO throw error if already exist
            }
        });
        addField("username", usernameField);

        addField("password", new PasswordField(password));
    }

    // make player object with clean values
    public Player createPlayer() throws FieldDoNotExistException {
        return new Player(getFieldValue("email"), getFieldValue("username"), getFieldValue("password"));
    }
}