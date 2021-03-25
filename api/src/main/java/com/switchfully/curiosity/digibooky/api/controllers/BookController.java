package com.switchfully.curiosity.digibooky.api.controllers;


import com.switchfully.curiosity.digibooky.api.dtomappers.BookMapper;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBook;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBookWithSummary;
import com.switchfully.curiosity.digibooky.service.BookService;
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

    @Autowired
    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<DtoBook> getAllBooks() {
        return bookMapper.changeListOfBooksToDto(bookService.getAllBooks());
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public DtoBookWithSummary getOneBook(@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        return bookMapper.changeBookToDtoWithSummary(bookService.getBookById(uuid));
    }


}
