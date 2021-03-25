package com.switchfully.curiosity.digibooky.domain.database;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;

import java.util.Collection;
import java.util.UUID;

public interface BookDatabase {
    Collection<Book> getAllBooks();
    Book getBookById(UUID uuid);
    Book addOneBook(Book book);
}
