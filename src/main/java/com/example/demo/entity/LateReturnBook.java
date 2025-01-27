package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
//@Table(name = "latebook")
public class LateReturnBook  {
	

//    @ManyToOne(fetch = FetchType.EAGER, optional = false,cascade=CascadeType.PERSIST)
//    @JoinColumn(name = "trans_id")
//    @JsonIgnore
 //   private TransactionHistory transactionHistory;
	private int trans_id;

	
//	@Column(name = "late_date", nullable = false)
	private LocalDate late_date;

//	@Column(name = "fine_amount", nullable = false)
	private double due;
}
