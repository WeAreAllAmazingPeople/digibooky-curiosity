package com.switchfully.curiosity.digibooky.domain.database;

import com.switchfully.curiosity.digibooky.domain.entities.Loan;

public interface LoanDatabase {

    Loan createLoan(Loan loan);
}
