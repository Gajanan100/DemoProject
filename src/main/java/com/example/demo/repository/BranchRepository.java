package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.custum.BranchLibrary;
import com.example.demo.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, BranchLibrary> {

	@Query(value = "select coalesce(max(b.branch_id),0)+1 from branch b where b.library_id=?",
			nativeQuery = true)
	int maxBarnchid(int library_id);
	
}
