package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmpRole;

@Repository
public interface EmpRoleRepository extends JpaRepository<EmpRole, Integer> {



}
