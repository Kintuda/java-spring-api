package com.trabalho.faculdade.services;

import com.trabalho.faculdade.models.Author;
import com.trabalho.faculdade.models.Book;
import com.trabalho.faculdade.repositories.AuthorRepository;
import com.trabalho.faculdade.utils.exceptions.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements CrudInterface<Author, Long> {

    @Autowired
    private AuthorRepository repository;

    @Autowired
    private BookService bookService;

    @Override
    public List<Author> getAll() {
        List<Author> authors = (List<Author>) repository.findAll();
        return authors;
    }

    @Override
    public Author findById(Long aLong) {
        if (!repository.existsById(aLong)) {
            throw new AuthorNotFoundException(aLong);
        }
        Optional<Author> author = repository.findById(aLong);
        return author.get();
    }

    @Override
    public Author update(Long aLong, Author author) {
        return repository.findById(aLong)
                .map(foundAuthor -> {
                    foundAuthor.setName(author.getName());
                    foundAuthor.setNationality(author.getNationality());
                    foundAuthor.setDateBirthDay(author.getDateBirthDay());
                    foundAuthor.setBooks(author.getBooks());
                    return repository.save(foundAuthor);
                }).orElse(null);
    }

    @Override
    public Author saveOrUpdate(Author author) {
        Author savedAuthor = repository.save(author);
        List<Book> books = author.getBooks();
        books.forEach(book -> {
            System.out.println(book.getName());
            book.setAuthor(author);
            bookService.saveOrUpdate(book);
        });
        return savedAuthor;
    }

    @Override
    public void delete(Author author) {
        repository.delete(author);
    }

    @Override
    public void deleteById(Long aLong) {
        if(!repository.existsById(aLong)){
            throw new AuthorNotFoundException(aLong);
        }
        repository.deleteById(aLong);
    }
}
