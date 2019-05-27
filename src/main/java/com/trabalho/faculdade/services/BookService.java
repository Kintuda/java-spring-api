package com.trabalho.faculdade.services;

import com.trabalho.faculdade.models.Author;
import com.trabalho.faculdade.models.Book;
import com.trabalho.faculdade.repositories.AuthorRepository;
import com.trabalho.faculdade.repositories.BookRepository;
import com.trabalho.faculdade.utils.exceptions.AuthorNotFoundException;
import com.trabalho.faculdade.utils.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements CrudInterface<Book, Long> {

    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Book> getAll() {
        List<Book> books = (List<Book>)  repository.findAll();
        return books;
    }

    @Override
    public Book findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public Book saveOrUpdate(Book book) {
        Author author = book.getAuthor();
        if(author == null){
            throw new AuthorNotFoundException(1);
        }
        return repository.save(book);
    }

    @Override
    public Book update(Long aLong, Book book) {
        return repository.findById(aLong)
                .map(foundBook -> {
                    foundBook.setName(book.getName());
                    foundBook.setDescription(book.getDescription());
                    foundBook.setPublication(book.getPublication());
                    foundBook.setPublisher(book.getPublisher());
                    foundBook.setAuthor(book.getAuthor());
                    return repository.save(foundBook);
                }).orElseThrow(()->new BookNotFoundException(aLong));
    }

    @Override
    public void delete(Book book) {
        repository.delete(book);
    }

    @Override
    public void deleteById(Long id) {
        if(!repository.existsById(id)){
            throw new BookNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
