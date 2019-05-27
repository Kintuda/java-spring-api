package com.trabalho.faculdade.controllers;

import com.trabalho.faculdade.models.Author;
import com.trabalho.faculdade.models.SucessResponse;
import com.trabalho.faculdade.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "author")
public class AuthorController {

	@Autowired
	private AuthorService service;

	@RequestMapping(method =  RequestMethod.GET)
	ResponseEntity<SucessResponse> getAllAuthors(){
		List<Author> authors = service.getAll();
		SucessResponse<List<Author>> sucessResponse = new SucessResponse<>(true,HttpStatus.OK, LocalDateTime.now(),authors);
		return new ResponseEntity<>(sucessResponse,sucessResponse.getStatus());
	}

	@RequestMapping(path = "/{id}", method =  RequestMethod.GET)
	ResponseEntity<SucessResponse> getById(@PathVariable Long id){
		Author author = service.findById(id);
		SucessResponse<Author> sucessResponse = new SucessResponse<>(true,HttpStatus.OK, LocalDateTime.now(),author);
		return ResponseEntity.ok(sucessResponse);
	}

	@RequestMapping(method =  RequestMethod.POST)
	ResponseEntity<SucessResponse> createAuthor(@RequestBody @Valid Author author){
		Author savedAuthor= service.saveOrUpdate(author);
		SucessResponse<Author> sucessResponse = new SucessResponse<Author>(true,HttpStatus.CREATED, LocalDateTime.now(),savedAuthor);
		return new ResponseEntity<>(sucessResponse,sucessResponse.getStatus());
	}

	@RequestMapping(path = "/{id}", method =  RequestMethod.PUT)
	ResponseEntity<SucessResponse> updateAuthor(@PathVariable Long id, @RequestBody @Valid Author author){
		Author updatedAuthor= service.update(id, author);
		SucessResponse<Author> sucessResponse = new SucessResponse<Author>(true,HttpStatus.OK, LocalDateTime.now(),updatedAuthor);
		return new ResponseEntity<>(sucessResponse,sucessResponse.getStatus());
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<SucessResponse> deleteAuthorById(@PathVariable Long id){
		service.deleteById(id);
		SucessResponse<Void> sucessResponse = new SucessResponse<>(true,HttpStatus.NO_CONTENT, LocalDateTime.now(),null);
		return new ResponseEntity<>(sucessResponse,sucessResponse.getStatus());
	}

	@RequestMapping(method = RequestMethod.DELETE)
	ResponseEntity<SucessResponse> deleteAuthor(@RequestBody Author author){
		service.delete(author);
		SucessResponse<Void> sucessResponse = new SucessResponse<>(true,HttpStatus.OK, LocalDateTime.now(),null);
		return new ResponseEntity<>(sucessResponse,sucessResponse.getStatus());
	}
}
