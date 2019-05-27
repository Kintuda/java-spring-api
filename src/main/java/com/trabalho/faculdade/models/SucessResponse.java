package com.trabalho.faculdade.models;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class SucessResponse<T> extends BaseResponse {
    private T dataResponse;

    public T getDataResponse() {
        return dataResponse;
    }

    public void setDataResponse(T dataResponse) {
        this.dataResponse = dataResponse;
    }

    public SucessResponse(Boolean sucess, HttpStatus status, LocalDateTime timestamp, T dataResponse) {
        super(sucess, status, timestamp);
        this.dataResponse = dataResponse;
    }
}
