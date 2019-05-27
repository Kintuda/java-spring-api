package com.trabalho.faculdade.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

@Entity
public class Author extends BaseModel{

    @NotBlank(message = "Nome do autor deve ser informado!")
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateBirthDay;

    @NotBlank(message="Nacionalidade do autor deve ser informado.")
    @Column(length = 100)
    private String nationality;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getNationality() {
        return nationality;
    }

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "author")
    private List<Book> books;

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDateBirthDay() {
        return dateBirthDay;
    }

    public void setDateBirthDay(Date dateBirthDay) {
        this.dateBirthDay = dateBirthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author(String name, Date dateBirthDay, String nationality, List<Book> books) {
        this.name = name;
        this.dateBirthDay = dateBirthDay;
        this.nationality = nationality;
        this.books = books;
    }

    public Author() {
    }
}
