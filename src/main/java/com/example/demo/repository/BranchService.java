package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.custum.BranchLibrary;
import com.example.demo.entity.Branch;

@Service
public interface BranchService {
	
	public Branch addBranch(Branch branch);
	public List<Branch>getallBranch();
	public void deleteByBranch(BranchLibrary branchLibrary);	
    Branch getBranchById(BranchLibrary branchLibrary); 
	public Branch UpdateBranch(Branch branch);




}
