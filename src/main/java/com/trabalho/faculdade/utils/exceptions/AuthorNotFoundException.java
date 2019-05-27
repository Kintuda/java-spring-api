package com.trabalho.faculdade.utils.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(long id){
        super("Autor com ID: " + id + " não foi encontrado.");
    }
}
