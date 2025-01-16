package com.example.demo.entity;

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
@Table(name = "emprole")
public class EmpRole {

	@Id
	@GeneratedValue(generator = "review_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "review_id", sequenceName = "review_id", initialValue = 1, allocationSize = 1)
	public int role_id;
	public String role;
	public String permission;
}
