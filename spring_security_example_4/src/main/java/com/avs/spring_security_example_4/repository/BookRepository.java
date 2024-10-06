package com.avs.spring_security_example_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avs.spring_security_example_4.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
