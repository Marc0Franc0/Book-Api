package com.app.controller;

import com.app.dto.BookDTO;
import com.app.model.Book;
import com.app.repository.BookRepository;
import com.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    BookRepository r;

    @GetMapping("/")
    public ResponseEntity<?> getBooks() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al solicitar la lista de libros");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.getBook(id).get());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al solicitar un libro");
        }
    }

    @PostMapping("test/")
    public ResponseEntity<?> createBook(@RequestBody BookDTO bookDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al crear el libro");
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createBook(@RequestBody Book book) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(r.save(book));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al crear el libro");
        }
    }
    @PutMapping("/")
    public ResponseEntity<?> modifyBook(@PathVariable String id,@RequestBody BookDTO bookDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.modifyBook(id,bookDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al solicitar un libro");
        }
    }
}
