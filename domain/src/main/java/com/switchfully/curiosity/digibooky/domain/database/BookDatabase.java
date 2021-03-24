package com.switchfully.curiosity.digibooky.domain.database;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;

import java.util.Collection;

public interface BookDatabase {
    Collection<Book> getAllBooks();
}
