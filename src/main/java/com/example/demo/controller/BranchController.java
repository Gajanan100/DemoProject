package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custum.BranchLibrary;
import com.example.demo.entity.Branch;
import com.example.demo.repository.BranchService;

@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;

	@PostMapping("/add-branch")
	public Branch addbranch(@RequestBody Branch branch) {
		return branchService.addBranch(branch);

	}

	@GetMapping("/get-branch")
	public List<Branch> getallBranch() {
		return branchService.getallBranch();
	}

	@GetMapping("/get-branch-id")
	public Branch getByBranchID(@RequestBody BranchLibrary branchLibrary) {
		branchLibrary.getBranch_id();
		branchLibrary.getLibrary_id();
		return branchService.getBranchById(branchLibrary);

	}

	@DeleteMapping("/del-branch-id")
	public String DeleteByBranchID(@RequestBody BranchLibrary branchLibrary) {
		branchLibrary.getBranch_id();
		branchLibrary.getLibrary_id();
		branchService.deleteByBranch(branchLibrary);
		return "DeleteLibrary SuccessFully";

	}

	@PutMapping("/add-update-branch")
	public Branch aupdateBranch(@RequestBody Branch branch) {
		return branchService.UpdateBranch(branch);
	}

}
