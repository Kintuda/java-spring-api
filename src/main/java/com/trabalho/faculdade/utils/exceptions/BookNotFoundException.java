package com.trabalho.faculdade.utils.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id){
        super("Livro com ID: " + id + " não foi encontrado");
    }
}
