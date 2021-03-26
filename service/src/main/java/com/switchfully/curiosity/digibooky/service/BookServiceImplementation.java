package com.switchfully.curiosity.digibooky.service;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import com.switchfully.curiosity.digibooky.domain.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
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
    public Book getBookById(UUID uuid) {
        return bookRepository.getBookById(uuid);
    }

    @Override
    public Book addOneBook(Book book) {
        return bookRepository.addOneBook(book);
    }

    @Override
    public List<Book> getBooksByTitle(String keyword) {
        if (keyword == null || keyword.equals("") || keyword.equals(" ")) {
            LOGGER.info("Invalid keyword, returning all the books");
            return List.copyOf(getAllBooks());
        }
        LOGGER.info("Valid keyword, returning all the books with matching titles");

        return getAllBooks().stream()
                .filter(((Predicate<Book>) book -> isMatchingNonCaseSensitive(keyword, book))
                        .or(book -> isMatchingRegex(keyword, book)))
                .collect(Collectors.toList());
    }

    private boolean isMatchingNonCaseSensitive(String keyword, Book book){
        return book.getTitle().toLowerCase().contains(keyword.toLowerCase());
    }

    private boolean isMatchingRegex(String keyword, Book book) {
        return Pattern.matches(keyword, book.getTitle().toLowerCase());
    }

}
