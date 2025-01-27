package com.example.demo.entity;

import java.sql.Date;

import com.example.demo.custum.BranchLibrary;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@IdClass(BranchLibrary.class)
@Table(name = "branch")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Branch {
    @Id
	private  int branch_id;
    @Id
	private int library_id;
//	@EmbeddedId
//	private BranchLibrary branchLibrary;

	private String location;
	private Date Buydate;
	private Date lastDate;
}
