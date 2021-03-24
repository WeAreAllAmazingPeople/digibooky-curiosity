package com.switchfully.curiosity.digibooky.api.dtomapper;

import com.switchfully.curiosity.digibooky.api.dtos.DtoBook;
import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class BookMapper {

    public List<DtoBook> changeListOfBooksToDto(Collection<Book> booksToChange){
        List<DtoBook> resultList = new ArrayList<>();
        for (Book book: booksToChange){
            resultList.add(changeBookToDto(book));
        }
        return resultList;
    }

    private DtoBook changeBookToDto(Book book) {
        DtoBook transformedBook = new DtoBook();
        transformedBook.setID(book.getId());
        transformedBook.setAuthor(book.getAuthor());
        transformedBook.setTitle(book.getTitle());
        transformedBook.setISBN(book.getISBN());
        return transformedBook;
    }
}
