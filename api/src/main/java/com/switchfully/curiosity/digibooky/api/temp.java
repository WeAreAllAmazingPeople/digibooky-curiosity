package com.switchfully.curiosity.digibooky.api;

import com.switchfully.curiosity.digibooky.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ohsilly")
class temp {              //TODO delete this
    private BookService bookService;

    @Autowired
    public temp(BookService bookService) {
        this.bookService = bookService;
    }

    public void iWantToUseMyService(){
        bookService.getAllBooks();
    }


    @GetMapping
    public String sayHello() {
        return "hello that's what you get";
    }
}
