package com.switchfully.curiosity.digibooky.domain.repositories;

import com.switchfully.curiosity.digibooky.domain.database.LoanDatabase;
import com.switchfully.curiosity.digibooky.domain.entities.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanRepositoryImplementation implements LoanRepository {

    private final LoanDatabase database;

    @Autowired
    public LoanRepositoryImplementation(LoanDatabase database) {
        this.database = database;
    }

    @Override
    public Loan createLoan(Loan loan) {
        return database.createLoan(loan);
    }
}
