package com.bhanu.ibapsych.form;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.bhanu.ibapsych.form.exception.FieldDoNotExistException;
import com.bhanu.ibapsych.form.exception.FieldExistsException;
import com.bhanu.ibapsych.form.field.FormField;

public class Form {
    // key: Field name, value: Field object
    private Hashtable<String, FormField> fields;
    // TODO add non field validators for form if necessary

    public Form() {
        fields = new Hashtable<>();
    }

    public void addField(String fieldName, FormField formField) throws FieldExistsException {
        // check if field with field name already exists
        if (fields.containsKey(fieldName)) {
            throw new FieldExistsException(fieldName);
        }
        // add field with given field name
        fields.put(fieldName, formField);
    }

    // validate the fields and return list of field errors
    public List<FieldError> validate() {
        List<FieldError> errors = new ArrayList<>();

        for (String fieldName : fields.keySet()) {
            FormField formField = fields.get(fieldName);

            List<String> errorMsgs = formField.validate();

            // if got some errors, add a field error
            if (errorMsgs.size() != 0) {
                errors.add(new FieldError(fieldName, errorMsgs));
            }
        }

        return errors;
    }

    public String getFieldValue(String fieldName) throws FieldDoNotExistException{
        // check if field with field name do not exist
        if (!fields.containsKey(fieldName)) {
            throw new FieldDoNotExistException(fieldName);
        }
        // get value of field with given field name
        return fields.get(fieldName).getValue();
    }
}