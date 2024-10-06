package com.avs.spring_security_example_4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avs.spring_security_example_4.model.Book;
import com.avs.spring_security_example_4.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public Optional<Book> getBookById(int id){
        Optional<Book> book = repo.findById(id);
        if(book == null){
            return null;
        }
        return book;
    }

    public List<Book> getAllBooks(){
        List<Book> books = repo.findAll();
        return books;
    }

    public Book addBook(Book book){
        return repo.save(book);
    }
    
}
