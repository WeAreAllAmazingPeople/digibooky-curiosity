package com.switchfully.curiosity.digibooky.domain.repositories;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;

import java.util.Collection;

public interface BookRepository {
    Collection<Book> getAllBooks();
}
