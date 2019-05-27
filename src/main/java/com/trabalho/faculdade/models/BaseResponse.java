package com.trabalho.faculdade.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class BaseResponse {
    private Boolean sucess;
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;

    public Boolean getSucess() {
        return sucess;
    }

    public void setSucess(Boolean sucess) {
        this.sucess = sucess;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus  status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public BaseResponse(Boolean sucess, HttpStatus status, LocalDateTime timestamp) {
        this.sucess = sucess;
        this.status = status;
        this.timestamp = timestamp;
    }
}
