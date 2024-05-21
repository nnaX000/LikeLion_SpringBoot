package com.example.study.service;

import com.example.study.entity.Book;
import com.example.study.model.AddBookInPut;
import com.example.study.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    public long addBook(AddBookInPut inPut){
        Book book= Book.builder()
                .name(inPut.getBookName())
                .price(String.valueOf(inPut.getBookPrice()))
                .build();
        Book saved=bookRepository.save(book);
        return saved.getId();
    }
}
