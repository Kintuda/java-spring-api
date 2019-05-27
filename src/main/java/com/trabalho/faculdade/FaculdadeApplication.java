package com.trabalho.faculdade;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.trabalho.faculdade.models.Book;
import com.trabalho.faculdade.repositories.BookRepository;

@SpringBootApplication
public class FaculdadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaculdadeApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner runner(BookRepository repository) {
//		return args -> {
//			repository.save();
//		};
//	}
}
