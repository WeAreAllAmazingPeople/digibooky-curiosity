package com.switchfully.curiosity.digibooky.api.controllers;

import com.switchfully.curiosity.digibooky.api.dtomappers.BookMapper;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBook;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBookWithSummary;
import com.switchfully.curiosity.digibooky.api.dtos.RegisterDtoBook;
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
    public List<DtoBook> getAllBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String isbn, @RequestParam(required = false) String authorName) {
        LOGGER.info("Getting all the books");
        return bookMapper.changeListOfBooksToDto(bookService.getAllBooks(title, isbn, authorName));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public DtoBookWithSummary getOneBook(@PathVariable("id") String id) {
        LOGGER.info("Getting one book with UUID " + id);
        UUID uuid = UUID.fromString(id);
        return bookMapper.changeBookToDtoWithSummary(bookService.getBookById(uuid));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DtoBook addOneBook(@RequestBody RegisterDtoBook registerDtoBook) {
        LOGGER.info("Creating a book");
        Book bookToRegister = bookMapper.changeRegisterDtoToBook(registerDtoBook);
        LOGGER.info("Registering a new book with UUID " + bookToRegister.getId());
        return bookMapper.changeBookToDto(bookService.addOneBook(bookToRegister));
    }
}


