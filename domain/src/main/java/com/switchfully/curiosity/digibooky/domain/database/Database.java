package com.switchfully.curiosity.digibooky.domain.database;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;

import java.util.Collection;

public interface Database {
    Collection<Book> getAllBooks();
}
