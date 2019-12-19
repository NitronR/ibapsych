package com.bhanu.ibapsych.form;

import java.io.Serializable;
import java.util.List;

public class FieldError implements Serializable {
    public String fieldName;
    // A field can have multiple errors
    public List<String> errorMsgs;

    public FieldError(String fieldName, List<String> errorMsgs) {
        this.fieldName = fieldName;
        this.errorMsgs = errorMsgs;
    }
}