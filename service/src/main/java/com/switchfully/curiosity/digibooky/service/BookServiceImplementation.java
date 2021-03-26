package com.switchfully.curiosity.digibooky.service;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import com.switchfully.curiosity.digibooky.domain.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
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
    public Collection<Book> getAllBooks(String titleKeyword, String isbnKeyword, String authorKeyword) {
        LOGGER.info("Getting all books by provided keywords");
        return bookRepository.getAllBooks().stream()
                .filter(book -> titleKeyword == null || isMatchingNonCaseSensitive(titleKeyword, book.getTitle()) || isMatchingRegex(titleKeyword, book.getTitle()))
                .filter(book -> isbnKeyword == null || isMatchingNonCaseSensitive(isbnKeyword, book.getISBN()) || isMatchingRegex(isbnKeyword, book.getISBN()))
                .filter(book -> authorKeyword == null || authorKeyword.equals(" ") || isMatchingNonCaseSensitive(authorKeyword, book.getAuthor().retrieveFullname()) || isMatchingRegex(authorKeyword, book.getAuthor().retrieveFullname()))
                .collect(Collectors.toList());
    }

    @Override
    public Book getBookById(UUID uuid) {
        LOGGER.info("Getting book by ID " + uuid);
        return bookRepository.getBookById(uuid);
    }

    @Override
    public Book createBook(Book book) {
        LOGGER.info("Adding one book");
        return bookRepository.createBook(book);
    }

    private boolean isMatchingNonCaseSensitive(String keyword, String content) {
        return content.toLowerCase().contains(keyword.toLowerCase());
    }

    private boolean isMatchingRegex(String keyword, String content) {
        return Pattern.matches(keyword, content.toLowerCase());
    }
}
