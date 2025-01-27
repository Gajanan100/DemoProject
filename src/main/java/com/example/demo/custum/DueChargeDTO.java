package com.example.demo.custum;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DueChargeDTO {
	private Date borrow_date;
	private Date return_date;
    private int extraDays;
    private int due_charge;
    // private Date currentDate;

}
