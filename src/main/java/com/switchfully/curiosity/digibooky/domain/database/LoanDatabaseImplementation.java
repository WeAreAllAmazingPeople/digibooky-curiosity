package com.switchfully.curiosity.digibooky.domain.database;

import com.switchfully.curiosity.digibooky.domain.entities.Loan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class LoanDatabaseImplementation implements LoanDatabase {

    private final Map<UUID, Loan> loans = new HashMap<>();

    @Override
    public Loan createLoan(Loan loan) {
        loans.put(loan.getId(), loan);
        return loans.get(loan.getId());
    }
}
