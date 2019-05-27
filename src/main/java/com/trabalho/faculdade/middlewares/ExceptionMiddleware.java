package com.trabalho.faculdade.middlewares;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import com.trabalho.faculdade.models.ErrorResponse;
import com.trabalho.faculdade.models.SubErrors;
import com.trabalho.faculdade.utils.exceptions.AuthorNotFoundException;
import com.trabalho.faculdade.utils.exceptions.BookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionMiddleware extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<SubErrors> errors = getErrors(ex);
        ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<SubErrors> errors) {
        ErrorResponse error = new ErrorResponse(false, status, status.getReasonPhrase(),LocalDateTime.now(),errors);
        return error;
    }

    private List<SubErrors> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new SubErrors(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }

    @ExceptionHandler({BookNotFoundException.class, AuthorNotFoundException.class})
    public ResponseEntity<ErrorResponse> customHandleNotFound(Exception ex, WebRequest request) {
        ErrorResponse errors = new ErrorResponse(false,HttpStatus.NOT_FOUND,ex.getMessage(),LocalDateTime.now(),null);
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}