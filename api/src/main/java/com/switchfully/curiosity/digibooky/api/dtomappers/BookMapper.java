package com.switchfully.curiosity.digibooky.api.dtomappers;

import com.switchfully.curiosity.digibooky.api.dtos.CreateDtoBook;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBook;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBookWithSummary;
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

    public List<DtoBook> changeCollectionOfBooksToListOfDtoBooks(Collection<Book> booksToChange) {
        LOGGER.info("Returned list of DtoBooks based on all Books in database");
        return booksToChange.stream()
                .map(this::changeBookToDtoBook)
                .collect(Collectors.toList());
    }

    public DtoBook changeBookToDtoBook(Book book) {
        LOGGER.info("Returned DtoBook based on book");
        return new DtoBook()
                .setID(book.getId())
                .setAuthor(book.getAuthor())
                .setTitle(book.getTitle())
                .setISBN(book.getISBN());
    }

    public DtoBookWithSummary changeBookToDtoBookWithSummary(Book book) {
        LOGGER.info("Returned DtoBookWithSummary based on book");
        if (book == null) throw new IllegalArgumentException("No book was found");
        return new DtoBookWithSummary()
                .setId(book.getId())
                .setAuthor(book.getAuthor())
                .setTitle(book.getTitle())
                .setISBN(book.getISBN())
                .setSummary(book.getSummary());
    }

    public Book changeCreateDtoBookToBook(CreateDtoBook createDtoBook) {
        LOGGER.info("Returned Book entity based on RegisterDtoBook");
        return new Book(createDtoBook.getISBN(),
                createDtoBook.getAuthor(),
                createDtoBook.getTitle(),
                createDtoBook.getSummary());
    }
}
