package com.switchfully.curiosity.digibooky.api.dtomappers;

import com.switchfully.curiosity.digibooky.api.dtos.CreateDtoBook;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBook;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBookWithoutSummary;
import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    private final Logger LOGGER = LoggerFactory.getLogger(BookMapper.class);

    public List<DtoBookWithoutSummary> changeCollectionOfBooksToListOfDtoBooks(Collection<Book> booksToChange) {
        LOGGER.info("Returned list of DtoBookWithoutSummary based on all Books in database");
        return booksToChange.stream()
                .map(this::changeBookToDtoBookWithoutSummary)
                .collect(Collectors.toList());
    }

    public DtoBookWithoutSummary changeBookToDtoBookWithoutSummary(Book book) {
        LOGGER.info("Returned DtoBookWithoutSummary based on book");
        return new DtoBookWithoutSummary()
                .setId(book.getId())
                .setAuthor(book.getAuthor())
                .setTitle(book.getTitle())
                .setIsbn(book.getIsbn());
    }

    public DtoBook changeBookToDtoBook(Book book) {
        LOGGER.info("Returned DtoBook based on book");
        if (book == null) throw new IllegalArgumentException("No book was found");
        return new DtoBook()
                .setId(book.getId())
                .setAuthor(book.getAuthor())
                .setTitle(book.getTitle())
                .setIsbn(book.getIsbn())
                .setSummary(book.getSummary());
    }

    public Book changeCreateDtoBookToBook(CreateDtoBook createDtoBook) {
        LOGGER.info("Returned Book entity based on CreateDtoBook");
        return new Book(createDtoBook.getIsbn(),
                createDtoBook.getAuthor(),
                createDtoBook.getTitle(),
                createDtoBook.getSummary());
    }
}
