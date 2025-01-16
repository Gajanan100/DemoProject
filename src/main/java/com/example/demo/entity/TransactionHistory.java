package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tranhistory")
public class TransactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int trans_id;
	public Date borrow_date;
	public Date late_date;
	public Date return_date;
	public double fineamount;

	@Column(name = "book_id", nullable = false)
	public int book_id;
	@Column(name = "userId", nullable = false)
	public int userId;

}
