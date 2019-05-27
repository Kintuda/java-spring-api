package com.trabalho.faculdade.controllers;

import com.trabalho.faculdade.models.Book;
import com.trabalho.faculdade.models.SucessResponse;
import com.trabalho.faculdade.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "book")
public class BookController {
    @Autowired
    private BookService service;

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<SucessResponse> findAll(){
        List<Book> books = service.getAll();
        SucessResponse<List<Book>> sucessResponse = new SucessResponse<>(true,HttpStatus.OK, LocalDateTime.now(),books);
        return new ResponseEntity<>(sucessResponse,sucessResponse.getStatus());
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    private ResponseEntity<SucessResponse> findOne(@PathVariable Long id){
        Book book = service.findById(id);
        SucessResponse<Book> sucessResponse = new SucessResponse<>(true,HttpStatus.OK, LocalDateTime.now(),book);
        return new ResponseEntity<>(sucessResponse,sucessResponse.getStatus());
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity<SucessResponse> createBook(@RequestBody Book book){
        Book savedBook = service.saveOrUpdate(book);
        SucessResponse<Book> sucessResponse = new SucessResponse<>(true,HttpStatus.CREATED, LocalDateTime.now(),savedBook);
        return new ResponseEntity<>(sucessResponse,sucessResponse.getStatus());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    private ResponseEntity<SucessResponse> updateBook(@PathVariable Long id, @RequestBody Book book){
        Book savedBook = service.update(id, book);
        SucessResponse<Book> sucessResponse = new SucessResponse<>(true,HttpStatus.OK, LocalDateTime.now(),savedBook);
        return new ResponseEntity<>(sucessResponse,sucessResponse.getStatus());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    private ResponseEntity<SucessResponse> deleteBook(@RequestBody Book book){
        service.delete(book);
        SucessResponse<Void> sucessResponse = new SucessResponse<>(true,HttpStatus.NO_CONTENT, LocalDateTime.now(),null);
        return new ResponseEntity<>(sucessResponse,sucessResponse.getStatus());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    private ResponseEntity<SucessResponse> deleteById(@PathVariable Long id){
        service.deleteById(id);
        SucessResponse<Void> sucessResponse = new SucessResponse<>(true,HttpStatus.NO_CONTENT, LocalDateTime.now(),null);
        return new ResponseEntity<>(sucessResponse,sucessResponse.getStatus());
    }
}
