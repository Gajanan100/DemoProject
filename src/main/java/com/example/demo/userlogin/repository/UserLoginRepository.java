package com.example.demo.userlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.userlogin.Users;

@Repository
public interface UserLoginRepository extends JpaRepository<Users, Integer> {
	
	Users findByUsername(String username);

}
