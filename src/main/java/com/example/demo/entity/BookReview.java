package com.example.demo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "bookreview")
public class BookReview {

	@Id
	@GeneratedValue(generator = "review_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "review_id", sequenceName = "review_id", initialValue = 1, allocationSize = 1)
	public int review_id;
	public int rating;
	public String review_text;
	public Date review_date;

	@Column(name = "book_id", nullable = false)
	public int book_id;
	@Column(name = "userId", nullable = false)
	public int userId;

}
