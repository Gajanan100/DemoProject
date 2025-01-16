package com.example.demo.custum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class FindEmployeByRole {

	public String role;
	public String permission;
	public String emp_name;
	public String contact;
	public String depeartment;
	public String address;

}
