package com.switchfully.curiosity.digibooky.domain.repositories;

import com.switchfully.curiosity.digibooky.domain.database.BookDatabase;
import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class BookRepositoryImplementation implements BookRepository {

    private final BookDatabase database;

    @Autowired
    public BookRepositoryImplementation(BookDatabase database) {
        this.database = database;
    }

    @Override
    public Collection<Book> getAllBooks() {
        return database.getAllBooks();
    }
}
