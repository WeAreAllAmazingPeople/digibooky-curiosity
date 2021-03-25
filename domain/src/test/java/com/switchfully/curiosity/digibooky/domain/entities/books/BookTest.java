package com.switchfully.curiosity.digibooky.domain.entities.books;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void whenCreatingBook_ifGivenNullISBN_thenThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> new Book(null, new Author("john", "doe"), "title", "summary"));
    }

    @Test
    void whenCreatingBook_ifGivenNullAuthorLastName_thenThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> new Book("978-3-16-148410-0", new Author("john", null), "title", "summary"));
    }

    @Test
    void whenCreatingBook_ifGivenNullTitle_thenThrowIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> new Book("978-3-16-148410-0", new Author("john", "doe"), null, "summary"));
    }

}