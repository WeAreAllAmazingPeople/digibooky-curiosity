package com.switchfully.curiosity.digibooky.dtos;

public class CreateDtoLoan {

    private String userId;
    private String bookIsbn;

    public CreateDtoLoan(String userId, String bookIsbn) {
        this.userId = userId;
        this.bookIsbn = bookIsbn;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }
}
