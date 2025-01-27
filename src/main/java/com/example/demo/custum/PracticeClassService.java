package com.example.demo.custum;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface PracticeClassService {
	
    public int save(PracticesClass practice);           
    public PracticesClass findById(int id);            
    public List<PracticesClass> findAll();             
    public  int delete(int id);  
    public int update(PracticesClass practice);

	
}
