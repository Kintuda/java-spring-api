package com.trabalho.faculdade.repositories;

import com.trabalho.faculdade.models.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
