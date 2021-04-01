package com.switchfully.curiosity.digibooky.api.dtomappers;

import com.switchfully.curiosity.digibooky.api.dtos.DtoLoan;
import com.switchfully.curiosity.digibooky.domain.entities.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    private final BookMapper bookMapper;
    private final UserMapper userMapper;

    @Autowired
    public LoanMapper(BookMapper bookMapper, UserMapper userMapper) {
        this.bookMapper = bookMapper;
        this.userMapper = userMapper;
    }

    public DtoLoan changeLoanToDtoLoan(Loan loan) {
        return new DtoLoan()
                .setBook(bookMapper.changeBookToDtoBook(loan.getBook()))
                .setId(loan.getId())
                .setDueDate(loan.getDueDate())
                .setUser(userMapper.changeUserToDtoUser(loan.getUser()));
    }
}
