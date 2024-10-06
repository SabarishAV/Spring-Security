package com.avs.spring_security_example_4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avs.spring_security_example_4.model.Book;
import com.avs.spring_security_example_4.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Integer id){
        Optional<Book> book = service.getBookById(id);
        return book;
    }

    @GetMapping("/")
    public List<Book> getAllBooks(){
        List<Book> books = service.getAllBooks();
        return books;
    }

    @PostMapping("/")
    public Book addBook(@RequestBody Book book){
        return service.addBook(book);
    }
    
}
