package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
//	@Query(value = "select count(is_active) from users where is_active=:is_active;",nativeQuery = true)
	@Query(value = "select is_active,count(user_id) as is_active_count from users Group By is_active;",nativeQuery = true)
	List<Object[]> countByIsActive();

}
