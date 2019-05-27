package com.trabalho.faculdade.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Book extends BaseModel{
    @NotBlank(message="Nome do livro deve ser informado!")
    private String name;

//    @NotBlank(message="Data de publicação do livro deve ser informado!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date publication;

    @NotBlank(message="Editora do livro deve ser informado!")
    private String publisher;

    @NotBlank(message = "Descrição do livro deve ser informado!")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    @JsonBackReference
    private Author author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(String name, Date publication, String publisher, String description, Author author) {
        this.name = name;
        this.publication = publication;
        this.publisher = publisher;
        this.description = description;
        this.author = author;
    }

    public Book() {

    }
}
