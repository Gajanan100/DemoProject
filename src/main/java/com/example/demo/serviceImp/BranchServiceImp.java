package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.custum.BranchLibrary;
//import com.example.demo.custum.BranchLibrary;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Library;
import com.example.demo.exception.BranchNotFoundException;
import com.example.demo.repository.BranchRepository;
import com.example.demo.repository.BranchService;
import com.example.demo.repository.LibraryRepository;

@Service
public class BranchServiceImp implements BranchService {

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private LibraryRepository libraryRepository;

	public Branch addBranch(Branch branch) {

		int BranchId = branchRepository.maxBarnchid(branch.getLibrary_id());
		branch.setBranch_id(BranchId);
		int libraryId = branch.getLibrary_id();

		Optional<Library> existingLibrary = libraryRepository.findById(libraryId);
		if (!existingLibrary.isPresent()) {
			throw new BranchNotFoundException("Library with ID " + libraryId + " does not exist.");
		}

		return branchRepository.save(branch);
	}

	@Override
	public List<Branch> getallBranch() {
		List<Branch> branchList = branchRepository.findAll();
		if (branchList.isEmpty()) {
			throw new BranchNotFoundException("Branch list is empty..");
		}
		return branchList;
	}
	// @Override
	// public Branch getBranchById(int id) {

//		Branch branch=new Branch();
//        int branchId = branch.getBranch_id();
//        BranchLibrary branchLibrary=new BranchLibrary();
//           Optional<Branch> optional=branchRepository.findById(id);   
//           if(optional.isEmpty()) {
//        	   throw new BranchNotFoundException("Branch Id Is Not Present");
//           }
//		          
//		return optional.get();
//	}

	@Override
	public void deleteByBranch(BranchLibrary branchLibrary) {
		if (branchRepository.findById(branchLibrary).isEmpty()) {
			throw new BranchNotFoundException("Branch ID and Library ID combination not found.");
		}

		branchRepository.deleteById(branchLibrary);
	}

	@Override
	public Branch getBranchById(BranchLibrary branchLibrary) {

		Optional<Branch> optional = branchRepository.findById(branchLibrary);
		if (optional.isEmpty()) {
			throw new BranchNotFoundException("Branch ID and Library ID combination not found.");
		}
		return optional.get();
	}

	@Override
	public Branch UpdateBranch(Branch branch) {
		Optional<Branch> optional = branchRepository
				.findById(new BranchLibrary(branch.getBranch_id(), branch.getLibrary_id()));
		if (optional.isPresent()) {
			branch.setBranch_id(optional.get().getBranch_id());
		} else {
			throw new BranchNotFoundException("Branch ID and Library ID combination not found.");

		}
		return branchRepository.save(branch);
	}

}
