package com.example.demo.custum;

import java.sql.Date;


public interface LateReturnBookDto {
    Date getBorrowDate();
    Date getReturnDate();
    int getExtraDays();
    double getDue();
}

