package com.trabalho.faculdade.models;

public class SubErrors {
    private String message;
    private String field;
    private Object parameter;

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }

    public SubErrors(String message, String field) {
        this.message = message;
        this.field = field;
    }
}
