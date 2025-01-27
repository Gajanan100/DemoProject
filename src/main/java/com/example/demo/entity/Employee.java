package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int emp_id;
	public String emp_name;
	public String contact;
	public String depeartment;
	public String address;
	public Date DOB;
	public String position;
//	@JoinColumn(name = "library_id")
	@JoinColumn(name = "library_id", nullable = false, foreignKey = @ForeignKey())
	public int library_id;
	@JoinColumn(name = "role_id",nullable = false)
	public int role_id;
	@JoinColumn(name = "book_id", nullable = false, foreignKey = @ForeignKey())
	public int book_id;
}
