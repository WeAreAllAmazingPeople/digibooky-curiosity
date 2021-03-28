package com.switchfully.curiosity.digibooky.service;

import com.switchfully.curiosity.digibooky.domain.entities.Loan;
import com.switchfully.curiosity.digibooky.domain.entities.books.Book;
import com.switchfully.curiosity.digibooky.domain.entities.users.User;
import com.switchfully.curiosity.digibooky.domain.repositories.BookRepository;
import com.switchfully.curiosity.digibooky.domain.repositories.LoanRepository;
import com.switchfully.curiosity.digibooky.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class LoanServiceImplementation implements LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public LoanServiceImplementation(LoanRepository loanRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Loan lendBook(UUID userId, String isbn) {
        User user = getUserById(userId);
        Book book = getBookByIsbn(isbn);
        book.lend();
        Book updatedBook = bookRepository.updateBook(book);
        return loanRepository.createLoan(new Loan(user, updatedBook));
    }

    private User getUserById(UUID userId){
        User user = userRepository.getUserById(userId);
        if (user == null) throw new IllegalArgumentException("Cannot find user by provided user id");
        return user;
    }

    private Book getBookByIsbn(String isbn) {
        Optional<Book> optionalBook = bookRepository.getAllBooks().stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .filter(Book::isAvailable)
                .findAny();
        if (optionalBook.isEmpty()) { // No book matching isbn available.
            throw new IllegalArgumentException("Cannot find available book by given ISBN");
        }
        return optionalBook.get();
    }
}
