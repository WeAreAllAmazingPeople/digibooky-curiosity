package com.switchfully.curiosity.digibooky.domain.repositories;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;

import java.util.Collection;
import java.util.UUID;

public interface BookRepository {
    Collection<Book> getAllBooks();
    Book getBookById(UUID uuid);

}
