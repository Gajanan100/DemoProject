package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserMembership;

@Repository
public interface UserMembershipRepository extends JpaRepository<UserMembership, Integer> {
	@Query(value="select max(m_id) from usermembership",nativeQuery = true)
	  Integer findmaxCount();


}
