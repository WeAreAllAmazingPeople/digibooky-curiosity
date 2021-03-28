package com.switchfully.curiosity.digibooky.api.controllers;

import com.switchfully.curiosity.digibooky.api.dtomappers.BookMapper;
import com.switchfully.curiosity.digibooky.api.dtos.CreateDtoBook;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBook;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBookWithoutSummary;
import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import com.switchfully.curiosity.digibooky.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);

    @Autowired
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<DtoBookWithoutSummary> getAllBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String isbn, @RequestParam(required = false) String authorName) {
        LOGGER.info("Getting all the books");
        return bookMapper.changeCollectionOfBooksToListOfDtoBooks(bookService.getAllBooks(title, isbn, authorName));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public DtoBook getBookById(@PathVariable("id") String id) {
        LOGGER.info("Getting one book with UUID " + id);
        UUID uuid = UUID.fromString(id);
        return bookMapper.changeBookToDtoBook(bookService.getBookById(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DtoBook createBook(@RequestBody CreateDtoBook createDtoBook) {
        LOGGER.info("Creating a book");
        Book bookToRegister = bookMapper.changeCreateDtoBookToBook(createDtoBook);
        LOGGER.info("Registering a new book with UUID " + bookToRegister.getId());
        return bookMapper.changeBookToDtoBook(bookService.createBook(bookToRegister));
    }
}


