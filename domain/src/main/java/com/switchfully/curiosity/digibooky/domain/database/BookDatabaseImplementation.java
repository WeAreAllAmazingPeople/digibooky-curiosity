package com.switchfully.curiosity.digibooky.domain.database;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class BookDatabaseImplementation implements BookDatabase {

    private final Map<UUID, Book> books = new HashMap<>();

    @Override
    public Collection<Book> getAllBooks() {
        return books.values();
    }
}