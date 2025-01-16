package com.example.demo.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	public int emp_id;
	public String emp_name;
	public String contact;
	public String depeartment;
	public String address;
	public Date DOB;
	public String position;
	public int library_id;

}
