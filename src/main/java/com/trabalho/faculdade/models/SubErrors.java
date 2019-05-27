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

    public Object getParameter() {
        return parameter;
    }

    public SubErrors(String message, String field, Object parameter) {
        this.message = message;
        this.field = field;
        this.parameter = parameter;
    }
}
