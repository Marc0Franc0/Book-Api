package com.app.service;

import com.app.dto.BookDTO;
import com.app.model.Book;
import com.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBook(String id) {
        return bookRepository.findById(id);
    }


    @Override
    public Book createBook(BookDTO bookDTO) {
        //Creación de objeto libro
        Book book = Book.builder()
                .name(bookDTO.getName())
                .author(bookDTO.getAuthor())
                .build();
        return bookRepository.save(book);
    }

    @Override
    public String modifyBook(String id,BookDTO bookDTO) {
        //Creación de objeto libro
        Book book = Book.builder()
                .id(String.valueOf(id))
                .name(bookDTO.getName())
                .author(bookDTO.getAuthor())
                .build();
        bookRepository.save(book);
        return "Libro con id '"+id+"' modificado correctamente";
    }

}
