package com.switchfully.curiosity.digibooky.service;

import com.switchfully.curiosity.digibooky.domain.entities.Loan;

import java.util.UUID;

public interface LoanService {
    Loan createLoan(UUID userId, String isbn);
}
