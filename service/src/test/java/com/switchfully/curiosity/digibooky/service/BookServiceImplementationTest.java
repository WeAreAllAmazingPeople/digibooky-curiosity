package com.switchfully.curiosity.digibooky.service;

import com.switchfully.curiosity.digibooky.domain.database.BookDatabaseImplementation;
import com.switchfully.curiosity.digibooky.domain.entities.books.Author;
import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import com.switchfully.curiosity.digibooky.domain.repositories.BookRepositoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookServiceImplementationTest {

    private BookServiceImplementation bookService;
    private Book book1;
    private Book book2;
    private Book book3;
    private Author author1;
    private Author author2;

    @BeforeEach
    public void init() {
        this.bookService = new BookServiceImplementation(new BookRepositoryImplementation(new BookDatabaseImplementation()));
        author1 = new Author("john", "doe");
        author2 = new Author("Jimmy", "Nitro");
        book1 = new Book("878-3-16-148410-1", author1, "a funny title", "summary");
        book2 = new Book("878-3-16-148410-2", author1, "a title serious", "summary");
        book3 = new Book("999-9-99-999999-9", author2, "not a ti-tl-e", "summary");
        bookService.createBook(book1);
        bookService.createBook(book2);
        bookService.createBook(book3);
    }

    //title search
    @Test
    void getBooksByTitle_givenNullKeyword_thenReturnAllBooks() {
        assertThat(List.of(book1, book2, book3)).hasSameElementsAs(bookService.getAllBooks(null, "", null));
    }

    @Test
    void getBooksByTitle_givenEmptyKeyword_thenReturnAllBooks() {
        assertThat(List.of(book1, book2, book3)).hasSameElementsAs(bookService.getAllBooks("", null, null));
    }

    @Test
    void getBooksByTitle_givenBlankSpaceKeyword_thenReturnAllBooks() {
        assertThat(List.of(book1, book2, book3)).hasSameElementsAs(bookService.getAllBooks(" ", null, null));
    }

    @Test
    void getBooksByTitle_givenKeywordTitle_thenReturn2MatchingBooks() {
        assertThat(List.of(book1, book2)).hasSameElementsAs(bookService.getAllBooks("title", null, null));
    }

    @Test
    void getBooksByTitle_givenKeywordFunny_thenReturn1MatchingBooks() {
        assertThat(List.of(book1)).hasSameElementsAs(bookService.getAllBooks("funny", null, null));
    }

    @Test
    void getBooksByTitle_givenWilcardKeywordFun_thenReturn2MatchingBooks() {
        assertThat(List.of(book1, book2)).hasSameElementsAs(bookService.getAllBooks(".*tit.*", null, null));
    }

    //isbn search
    @Test
    void getBooksByIsbn_givenNullKeyword_thenReturnAllBooks() {
        assertThat(List.of(book1, book2, book3)).hasSameElementsAs(bookService.getAllBooks("", null, null));
    }

    @Test
    void getBooksByIsbn_givenEmptyKeyword_thenReturnAllBooks() {
        assertThat(List.of(book1, book2, book3)).hasSameElementsAs(bookService.getAllBooks(null, "", null));
    }

    @Test
    void getBooksByIsbn_givenBlankSpaceKeyword_thenReturnEmptyList() {
        assertThat(List.of()).hasSameElementsAs(bookService.getAllBooks(null, " ", null));
    }

    @Test
    void getBooksByIsbn_givenPartialKeywordIsbn_thenReturn2MatchingBooks() {
        assertThat(List.of(book1, book2)).hasSameElementsAs(bookService.getAllBooks(null, "878-3-16-148410", null));
    }

    @Test
    void getBooksByIsbn_givenPartialKeywordIsbn_thenReturn1MatchingBooks() {
        assertThat(List.of(book3)).hasSameElementsAs(bookService.getAllBooks(null, "999", null));
    }

    @Test
    void getBooksByIsbn_givenWilcardKeyword16_thenReturn2MatchingBooks() {
        assertThat(List.of(book1, book2)).hasSameElementsAs(bookService.getAllBooks(null, ".*-16.*", null));
    }

    //author search
    @Test
    void getBooksByAuthor_givenNullKeyword_thenReturnAllBooks() {
        assertThat(List.of(book1, book2, book3)).hasSameElementsAs(bookService.getAllBooks("", null, null));
    }

    @Test
    void getBooksByAuthor_givenEmptyKeyword_thenReturnAllBooks() {
        assertThat(List.of(book1, book2, book3)).hasSameElementsAs(bookService.getAllBooks(null, null, ""));
    }

    @Test
    void getBooksByAuthor_givenBlankSpaceKeyword_thenReturnAllBooks() {
        assertThat(List.of(book1, book2, book3)).hasSameElementsAs(bookService.getAllBooks(null, null, " "));
    }

    @Test
    void getBooksByAuthor_givenAuthorPartialFirstname_thenReturn2MatchingBooks() {
        assertThat(List.of(book1, book2)).hasSameElementsAs(bookService.getAllBooks(null, null, "joh"));
    }

    @Test
    void getBooksByAuthor_givenAuthorPartialLastname_thenReturn1MatchingBooks() {
        assertThat(List.of(book3)).hasSameElementsAs(bookService.getAllBooks(null, null, "nit"));
    }

    @Test
    void getBooksByAuthor_givenAuthorFullname_thenReturn2MatchingBooks() {
        assertThat(List.of(book1, book2)).hasSameElementsAs(bookService.getAllBooks(null, null, "john doe"));
    }

    @Test
    void getBooksByAuthor_givenWilcardKeywordDo_thenReturn2MatchingBooks() {
        assertThat(List.of(book1, book2)).hasSameElementsAs(bookService.getAllBooks(null, null, ".*do.*"));
    }

    //mixed search
    @Test
    void getBooksByTitleIsbnAuthor_givenMultiplePartialKeywords_thenReturn2MatchingBooks() {
        assertThat(List.of(book1, book2)).hasSameElementsAs(bookService.getAllBooks("ti", "878", ".*do.*"));
    }
}