package com.switchfully.curiosity.digibooky.service;

import com.switchfully.curiosity.digibooky.domain.entities.books.Book;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    //methods used by controller

     Collection<Book> getAllBooks();
    Collection<Book> getAllBooks(String title, String isbn);
     Book getBookById(UUID uuid);
     Book addOneBook(Book book);

}
