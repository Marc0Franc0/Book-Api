package com.app;

import com.app.controller.BookController;
import com.app.dto.BookDTO;
import com.app.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class BooksApplicationTests {
	@Autowired
	BookController bookController;
	@Test
	void contextLoads() {

	}

	@Test
	void testApp(){
		createBook();
		getBook();
		modify();
		getBookModified();
	}

	void createBook(){
		ResponseEntity<?> endpoint = bookController.createBook
				(Book.builder().id("655645644848").name("Libro 1").author("Autor libro 1").build());
		int status = endpoint.getStatusCode().value();
		System.out.println("'Creacion libro'->Status: "+status+".Body: "+endpoint.getBody().toString());
	}

	void getBook(){
		ResponseEntity<?> endpoint = bookController.getBook("655645644848");
		int status = endpoint.getStatusCode().value();
		System.out.println("'Obtención de libro creado'->Status: "+status+".Body: "+endpoint.getBody().toString());

	}

	void modify(){
		ResponseEntity<?> endpoint = bookController.modifyBook("655645644848",BookDTO.builder()
				.name("Libro 1 modificado")
				.author("Autor libro 1 modificado").build());
		int  status =  endpoint.getStatusCode().value();
		System.out.println("'Modificación de libro creado anteriormente'->Status: "+status+".Body: "+endpoint.getBody().toString());
	}

	void getBookModified(){
		ResponseEntity<?> endpoint = bookController.getBook("655645644848");
		int status = endpoint.getStatusCode().value();
		System.out.println("'Obtención de libro modificado'->Status: "+status+".Body: "+endpoint.getBody().toString());


	}
}
