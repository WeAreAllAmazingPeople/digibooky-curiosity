package com.switchfully.curiosity.digibooky.api.controllers;

import com.switchfully.curiosity.digibooky.api.dtomappers.LoanMapper;
import com.switchfully.curiosity.digibooky.api.dtos.CreateDtoLoan;
import com.switchfully.curiosity.digibooky.api.dtos.DtoLoan;
import com.switchfully.curiosity.digibooky.domain.entities.Loan;
import com.switchfully.curiosity.digibooky.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;
    private final LoanMapper loanMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    public LoanController(LoanService loanService, LoanMapper loanMapper) {
        this.loanService = loanService;
        this.loanMapper = loanMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DtoLoan loanBook(@RequestBody CreateDtoLoan createDtoLoan) {
        LOGGER.info("Creating a loan");
        Loan loan = loanService.lendBook(UUID.fromString(createDtoLoan.getUserId()), createDtoLoan.getBookIsbn());
        return loanMapper.changeLoanToDtoLoan(loan);
    }
}
