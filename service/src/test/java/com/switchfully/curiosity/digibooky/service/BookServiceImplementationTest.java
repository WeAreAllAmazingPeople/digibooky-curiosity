package com.switchfully.curiosity.digibooky.service;

import com.switchfully.curiosity.digibooky.domain.database.BookDatabaseImplementation;
import com.switchfully.curiosity.digibooky.domain.entities.books.Author;
import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import com.switchfully.curiosity.digibooky.domain.repositories.BookRepositoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplementationTest {


    private BookServiceImplementation bookService;
    private  Book book1;
    private  Book book2;
    private  Book book3;
    private  Author author1;

    @BeforeEach
    public void init() {
        this.bookService = new BookServiceImplementation(new BookRepositoryImplementation(new BookDatabaseImplementation()));
        author1 = new Author("john", "doe");
        book1 = new Book("f87c152c-8d47-11eb-8dcd-0242ac130001", "978-3-16-148410-1", author1, "a funny title", "summary");
        book2 = new Book("f87c152c-8d47-11eb-8dcd-0242ac130002", "978-3-16-148410-2", author1, "a title serious", "summary");
        book3 = new Book("f87c152c-8d47-11eb-8dcd-0242ac130003", "978-3-16-148410-3", author1, "not a ti-tl-e", "summary");
        bookService.addOneBook(book1);
        bookService.addOneBook(book2);
        bookService.addOneBook(book3);
    }


    @Test
    void getBooksByTitle_givenNullKeyword_thenReturnAllBooks() {
         assertEquals(List.of(book1, book2, book3),bookService.getAllBooks(null));
    }

    @Test
    void getBooksByTitle_givenEmptyKeyword_thenReturnAllBooks() {
        assertEquals(List.of(book1, book2, book3), bookService.getAllBooks(""));
    }

    @Test
    void getBooksByTitle_givenBlankSpaceKeyword_thenReturnAllBooks() {
        assertEquals(List.of(book1, book2,book3), bookService.getAllBooks(" "));
    }

    @Test
    void getBooksByTitle_givenKeywordTitle_thenReturn2MatchingBooks() {
        assertEquals(List.of(book1, book2), bookService.getAllBooks("title"));
    }

    @Test
    void getBooksByTitle_givenKeywordFunny_thenReturn1MatchingBooks() {
        assertEquals(List.of(book1), bookService.getAllBooks("funny"));
    }
    @Test
    void getBooksByTitle_givenWilcardKeywordFun_thenReturn1MatchingBooks() {
        assertEquals(List.of(book1,book2), bookService.getAllBooks(".*tit.*"));
    }

}