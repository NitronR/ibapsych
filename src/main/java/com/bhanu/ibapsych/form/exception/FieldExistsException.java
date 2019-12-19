package com.bhanu.ibapsych.form.exception;

public class FieldExistsException extends Exception {
    
    public FieldExistsException(String fieldName) {
        super("Field with name " + fieldName + " already exists.");
    }
}