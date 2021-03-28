package com.switchfully.curiosity.digibooky.api.controllers;

import com.switchfully.curiosity.digibooky.api.dtomappers.BookMapper;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBookWithSummary;
import com.switchfully.curiosity.digibooky.domain.database.BookDatabaseImplementation;
import com.switchfully.curiosity.digibooky.domain.entities.books.Author;
import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import com.switchfully.curiosity.digibooky.domain.repositories.BookRepositoryImplementation;
import com.switchfully.curiosity.digibooky.service.BookServiceImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class BookControllerTest {

    private BookDatabaseImplementation bookDatabase;
    private BookController bookController;

    @BeforeEach
    public void init() {
        bookDatabase = new BookDatabaseImplementation();
        bookController = new BookController(new BookServiceImplementation(new BookRepositoryImplementation(bookDatabase)), new BookMapper());
    }

    @Test
    void whenGettingBookById_thenCorrectBookIsReturned() {
        Author author = new Author("john", "doe");
        Book testBook = new Book("isbn", author, "title", "summary");
        String BookId = testBook.getId().toString();
        bookDatabase.createBook(testBook);

        DtoBookWithSummary dtoBookWithSummary = new DtoBookWithSummary()
                .setId(UUID.fromString(BookId))
                .setIsbn("isbn")
                .setAuthor(author)
                .setTitle("title")
                .setSummary("summary");

        DtoBookWithSummary getOneResult = bookController.getOneBook(BookId);

        assertThat(getOneResult.getSummary()).isEqualTo(dtoBookWithSummary.getSummary());
        assertThat(getOneResult.getTitle()).isEqualTo(dtoBookWithSummary.getTitle());
        assertThat(getOneResult.getIsbn()).isEqualTo(dtoBookWithSummary.getIsbn());
    }

}