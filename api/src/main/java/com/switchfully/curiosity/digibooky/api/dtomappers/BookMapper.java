package com.switchfully.curiosity.digibooky.api.dtomappers;

import com.switchfully.curiosity.digibooky.api.dtos.DtoBook;
import com.switchfully.curiosity.digibooky.api.dtos.DtoBookWithSummary;
import com.switchfully.curiosity.digibooky.api.dtos.RegisterDtoBook;
import com.switchfully.curiosity.digibooky.domain.entities.books.Author;
import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public List<DtoBook> changeListOfBooksToDto(Collection<Book> booksToChange) {
        return booksToChange.stream()
                .map(this::changeBookToDto)
                .collect(Collectors.toList());
    }

    public DtoBook changeBookToDto(Book book) {
        return new DtoBook()
                .setID(book.getId())
                .setAuthor(book.getAuthor())
                .setTitle(book.getTitle())
                .setISBN(book.getISBN());
    }

    public DtoBookWithSummary changeBookToDtoWithSummary(Book book) {
        return new DtoBookWithSummary()
                .setID(book.getId())
                .setAuthor(book.getAuthor())
                .setTitle(book.getTitle())
                .setISBN(book.getISBN())
                .setSummary(book.getSummary());
    }

    public Book changeRegisterDtoToBook(RegisterDtoBook registerDtoBook) {
        Author tempAuthor = new Author("", registerDtoBook.getAuthorLastName());
        return new Book(registerDtoBook.getISBN(), tempAuthor, registerDtoBook.getTitle());
    }
}