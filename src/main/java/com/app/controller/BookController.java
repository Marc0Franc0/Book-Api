package com.app.controller;

import com.app.dto.BookDTO;
import com.app.model.Book;
import com.app.repository.BookRepository;
import com.app.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    BookRepository repository;
    //Entrypoint para obtener una lista de todos los libros
    @GetMapping("/")
    public ResponseEntity<?> getBooks() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al solicitar la lista de libros");
        }

    }
    //Entrypoint para obtener un libro
    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.getBook(id).get());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al solicitar un libro");
        }
    }
    //Entrypoint para crear y almacenar un nuevo libro
    @PostMapping("/")
    public ResponseEntity<?> createBook(@RequestBody @Valid BookDTO bookDTO, BindingResult bindingResult) {
        //Validacion de datos
        if(bindingResult.hasErrors()){
            //En caso de error
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(bindingResult.getFieldError().getDefaultMessage());
        }else{
            //En caso de validacion de datos correcta
            try {
                return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookDTO));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al crear el libro");
            }
        }

    }

    //Metodo utilizado para testear funcionalidades
    public ResponseEntity<?> createBook(@RequestBody Book book) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(book));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al crear el libro");
        }
    }
    //Metodo utilizado para testear funcionalidades
    public ResponseEntity<?> modifyBook(String id,@RequestBody BookDTO bookDTO) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.modifyBook(id,bookDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al crear el libro");
        }


    }
    //Entrypoint para la modificación de un libro
    @PutMapping("/")
    public ResponseEntity<?> modifyBook(@PathVariable String id,@RequestBody @Valid BookDTO bookDTO,
                                        BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            //En caso de error
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(bindingResult.getFieldError().getDefaultMessage());
        }else{
            //En caso de validacion de datos correcta
            try {
                return ResponseEntity.status(HttpStatus.OK).body(bookService.modifyBook(id,bookDTO));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al solicitar un libro");
            }
        }

    }
}
