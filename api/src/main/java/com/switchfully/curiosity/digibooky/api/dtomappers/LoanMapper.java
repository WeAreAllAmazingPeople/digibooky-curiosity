package com.switchfully.curiosity.digibooky.api.dtomappers;

import com.switchfully.curiosity.digibooky.api.dtos.DtoLoan;
import com.switchfully.curiosity.digibooky.domain.entities.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    public DtoLoan changeLoanToDto(Loan loan) {
        return new DtoLoan()
                .setBook(loan.getBook())
                .setId(loan.getId())
                .setDueDate(loan.getDueDate())
                .setUser(loan.getUser());
    }
}
