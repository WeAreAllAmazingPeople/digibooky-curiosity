package com.switchfully.curiosity.digibooky;

import com.switchfully.curiosity.digibooky.dtos.*;
import com.switchfully.curiosity.digibooky.domain.Loan;
import com.switchfully.curiosity.digibooky.domain.Book;
import com.switchfully.curiosity.digibooky.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/")
public class BookController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);


    @GetMapping(path = "books", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<DtoBookWithoutSummary> getAllBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String isbn, @RequestParam(required = false) String authorName) {
        LOGGER.info("Getting all the books");
        List<DtoBookWithoutSummary> list = new ArrayList<>();
        for (Book book : getAllBooksBooks(title, isbn, authorName)) {
            DtoBookWithoutSummary dtoBookWithoutSummary = new DtoBookWithoutSummary()
                    .setId(book.getId())
                    .setAuthor(book.getAuthor())
                    .setTitle(book.getTitle())
                    .setIsbn(book.getIsbn());
            list.add(dtoBookWithoutSummary);
        }
        return list;
    }

    @GetMapping(path = "books/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public DtoBook getBookById(@PathVariable("id") String id) {
        LOGGER.info("Getting one book with UUID " + id);
        UUID uuid = UUID.fromString(id);
        Book book = getBookById(uuid);
        if (book == null) throw new IllegalArgumentException("No book was found");
        return new DtoBook()
                .setId(book.getId())
                .setAuthor(book.getAuthor())
                .setTitle(book.getTitle())
                .setIsbn(book.getIsbn())
                .setSummary(book.getSummary());
    }

    @PostMapping(path = "books", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DtoBook createBook(@RequestBody CreateDtoBook createDtoBook) {
        LOGGER.info("Creating a book");
        Book bookToRegister = new Book(createDtoBook.getIsbn(),
                createDtoBook.getAuthor(),
                createDtoBook.getTitle(),
                createDtoBook.getSummary());
        LOGGER.info("Registering a new book with UUID " + bookToRegister.getId());
        Book book = createBook(bookToRegister);
        if (book == null) throw new IllegalArgumentException("No book was found");
        return new DtoBook()
                .setId(book.getId())
                .setAuthor(book.getAuthor())
                .setTitle(book.getTitle())
                .setIsbn(book.getIsbn())
                .setSummary(book.getSummary());
    }

    @PostMapping(path = "loan", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DtoLoan createLoan(@RequestBody CreateDtoLoan createDtoLoan) {
        LOGGER.info("Creating a loan");
        Loan loan = createLoan(UUID.fromString(createDtoLoan.getUserId()), createDtoLoan.getBookIsbn());
        Book book = loan.getBook();
        if (book == null) throw new IllegalArgumentException("No book was found");
        User user = loan.getUser();
        //BUILDER SETTERS ON (FLUENT API)
        //NOT BUILDER SETTERS
//        DtoUser dtoUser = new DtoUser();
//        dtoUser.setId(user.getId());
//        dtoUser.setINSS(user.getInss());
//        dtoUser.setLastName(user.getLastname());
//        dtoUser.setFirstName(user.getFirstname());
//        dtoUser.setEmail(user.getEmail());
//        dtoUser.setAddress(user.getAddress());
//        return dtoUser;
        return new DtoLoan()
                .setBook(new DtoBook()
                        .setId(book.getId())
                        .setAuthor(book.getAuthor())
                        .setTitle(book.getTitle())
                        .setIsbn(book.getIsbn())
                        .setSummary(book.getSummary()))
                .setId(loan.getId())
                .setDueDate(loan.getDueDate())
                .setUser(new DtoUser()
                        .setId(user.getId())
                        .setInss(user.getInss())
                        .setLastName(user.getLastname())
                        .setFirstName(user.getFirstname())
                        .setEmail(user.getEmail())
                        .setAddress(user.getAddress()));
    }

    public Loan createLoan(UUID userId, String isbn) {
        User user = getUserById(userId);
        Book book = getBookByIsbn(isbn);
        book.lend();
        Book updatedBook = updateBook(book);
        return createLoan(new Loan(user, updatedBook));
    }


    private Book getBookByIsbn(String isbn) {
        Optional<Book> optionalBook = getAllBooks().stream()
                .filter(book -> isbn.equals(book.getIsbn()))
                .filter(Book::isAvailable)
                .findAny();
        if (optionalBook.isEmpty()) { // No book matching isbn available.
            throw new IllegalArgumentException("Cannot find available book by given ISBN");
        }
        return optionalBook.get();
    }

    public Collection<Book> getAllBooksBooks(String titleKeyword, String isbnKeyword, String authorKeyword) {
        LOGGER.info("Getting all books by provided keywords");
        return getAllBooks().stream()
                .filter(book -> titleKeyword == null || isMatchingNonCaseSensitive(titleKeyword, book.getTitle()) || isMatchingRegex(titleKeyword, book.getTitle()))
                .filter(book -> isbnKeyword == null || isMatchingNonCaseSensitive(isbnKeyword, book.getIsbn()) || isMatchingRegex(isbnKeyword, book.getIsbn()))
                .filter(book -> authorKeyword == null || authorKeyword.equals(" ") || isMatchingNonCaseSensitive(authorKeyword, book.getAuthor().retrieveFullname()) || isMatchingRegex(authorKeyword, book.getAuthor().retrieveFullname()))
                .collect(Collectors.toList());
    }

    private boolean isMatchingNonCaseSensitive(String keyword, String content) {
        return content.toLowerCase().contains(keyword.toLowerCase());
    }

    private boolean isMatchingRegex(String keyword, String content) {
        return Pattern.matches(keyword, content.toLowerCase());
    }

    @PostMapping(path = "user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DtoUser createUser(@RequestBody CreateDtoUser createDtoUser) {
        LOGGER.info("Starting User Registration");
        //Create user
        User userToRegister = new User(
                createDtoUser.getInss(),
                createDtoUser.getLastName(),
                createDtoUser.getFirstName(),
                createDtoUser.getEmail(),
                createDtoUser.getAddress()
        );

        //Call service to create user
        User createdUser = createUser(userToRegister);
        LOGGER.info("Created user with ID: " + userToRegister.getId());

        //Returns a new user created
        //BUILDER SETTERS ON (FLUENT API)
        return new DtoUser()
                .setId(createdUser.getId())
                .setInss(createdUser.getInss())
                .setLastName(createdUser.getLastname())
                .setFirstName(createdUser.getFirstname())
                .setEmail(createdUser.getEmail())
                .setAddress(createdUser.getAddress());
        //NOT BUILDER SETTERS
//        DtoUser dtoUser = new DtoUser();
//        dtoUser.setId(user.getId());
//        dtoUser.setINSS(user.getInss());
//        dtoUser.setLastName(user.getLastname());
//        dtoUser.setFirstName(user.getFirstname());
//        dtoUser.setEmail(user.getEmail());
//        dtoUser.setAddress(user.getAddress());
//        return dtoUser;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(IllegalArgumentException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    public void handleIllegalStateException(IllegalStateException exception, HttpServletResponse response) throws IOException {
        LOGGER.warn(exception.getMessage(), exception);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, exception.getMessage());
    }

    private final Map<UUID, Book> books = new HashMap<>();

    public Collection<Book> getAllBooks() {
        return books.values();
    }

    public Book getBookById(UUID uuid) {
        return books.get(uuid);
    }

    public Book createBook(Book book) {
        books.put(book.getId(), book);
        return books.get(book.getId());
    }

    public Book updateBook(Book book) {
        books.put(book.getId(),book);
        return books.get(book.getId());
    }

    private final Map<UUID, Loan> loans = new HashMap<>();

    public Loan createLoan(Loan loan) {
        loans.put(loan.getId(), loan);
        return loans.get(loan.getId());
    }

    private final Map<UUID, User> userMap = new HashMap<>();

    public User createUser(User user) {
        addUser(user);
        return userMap.get(user.getId());
    }

    public User getUserById(UUID userId) {
        User user = userMap.get(userId);
        if (user == null) throw new IllegalArgumentException("Cannot find user by provided user id");
        return user;
    }

    private void addUser(User user) {
        if (!isNewUser(user)) {
            throw new IllegalArgumentException("User already exists");
        }
        userMap.put(user.getId(), user);
    }

    boolean isNewUser(User user) {//TODO unique:id, inss, email -> TESTS + VALIDATION (TDD)
        return true;
    }
}


