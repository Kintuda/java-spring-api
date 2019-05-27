package com.trabalho.faculdade.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;


public class ErrorResponse extends BaseResponse{
    private String message;
    private List<SubErrors> errors;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SubErrors> getErrors() {
        return errors;
    }

    public void setErrors(List<SubErrors> errors) {
        this.errors = errors;
    }

    public ErrorResponse(Boolean sucess, HttpStatus status, String message, LocalDateTime timestamp, List<SubErrors> errors) {
        super(sucess, status, timestamp);
        this.errors = errors;
        this.message = message;
    }
}