package com.switchfully.curiosity.digibooky.domain.entities.books;

import java.util.Objects;
import java.util.UUID;

public class Book {

    private final UUID id;
    private final String isbn;     //Option: TODO make value object with ISBN
    private final Author author;
    private final String title;
    private String summary;
    private boolean isAvailable = true;

    public Book(String isbn, Author author, String title, String summary) {
        this(isbn, author, title);
        this.summary = summary;
    }

    public Book(String isbn, Author author, String title) {
        validateInput(isbn, author, title);
        this.id = UUID.randomUUID();
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    private void validateInput(String isbn, Author author, String title) {
        if (isbn == null || author.getLastname() == null || title == null)
            throw new IllegalArgumentException("Cannot create book, invalid input");
    }

    public void lend() {
        if (!isAvailable) {
            throw new IllegalStateException("Book not available");
        }
        this.isAvailable = false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public UUID getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
