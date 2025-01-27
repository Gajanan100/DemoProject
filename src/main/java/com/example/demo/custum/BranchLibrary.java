package com.example.demo.custum;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//@Embeddable
public class BranchLibrary implements Serializable {
    private static final long serialVersionUID = 1L;
	private int branch_id;
	private int library_id;
}
