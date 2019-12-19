package com.bhanu.ibapsych.form.exception;

public class FieldDoNotExistException extends Exception {
    
    public FieldDoNotExistException(String fieldName) {
        super("Field with name " + fieldName + " do not exist.");
    }
}