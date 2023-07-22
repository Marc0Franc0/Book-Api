package com.app.service;

import com.app.dto.BookDTO;
import com.app.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    public List<Book> getBooks();

    public Optional<Book> getBook(String id);

    public Book createBook(BookDTO bookDTO);

    public String modifyBook(String id, BookDTO bookDTO);
}
