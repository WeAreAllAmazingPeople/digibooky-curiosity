package com.switchfully.curiosity.digibooky.domain.repositories;

import com.switchfully.curiosity.digibooky.domain.entities.Loan;

public interface LoanRepository {

    Loan createLoan(Loan loan);
}
