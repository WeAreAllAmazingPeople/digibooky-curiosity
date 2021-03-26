package com.switchfully.curiosity.digibooky.service;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import com.switchfully.curiosity.digibooky.domain.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.regex.*;

@Component
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(BookServiceImplementation.class);


    @Autowired
    public BookServiceImplementation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Collection<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public Collection<Book> getAllBooks(String titleKeyword, String isbnKeyword) {
        return bookRepository.getAllBooks().stream()
                .filter(book -> titleKeyword == null || isMatchingNonCaseSensitive(titleKeyword, book.getTitle()) || isMatchingRegex(titleKeyword, book.getTitle()))
                .filter(book -> isbnKeyword == null || isMatchingIsbn(isbnKeyword, book.getISBN()) || isMatchingRegex(isbnKeyword, book.getISBN()))
                .collect(Collectors.toList());
    }

    @Override
    public Book getBookById(UUID uuid) {
        return bookRepository.getBookById(uuid);
    }

    @Override
    public Book addOneBook(Book book) {
        return bookRepository.addOneBook(book);
    }

    private boolean isMatchingIsbn(String isbnKeyword, String isbn) {
        return isbn.contains(isbnKeyword);
    }

    private boolean isMatchingNonCaseSensitive(String keyword, String title){
        return title.toLowerCase().contains(keyword.toLowerCase());
    }

    private boolean isMatchingRegex(String keyword, String title) {
        return Pattern.matches(keyword, title.toLowerCase());
    }

}
