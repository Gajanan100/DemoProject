package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custum.PracticeClassImp;
import com.example.demo.custum.PracticesClass;

@RestController
public class PracticeController {
	
	@Autowired
	private PracticeClassImp classService;
	
	@PostMapping("/add-prac")
	public int addPracData(@RequestBody PracticesClass practicesClass) {
		return classService.save(practicesClass); 
		
	}
    @GetMapping("/get-prac")
    public PracticesClass getPracticeById(@RequestBody PracticesClass prac) {
        return classService.findById(prac.getId());
    }
    
    @GetMapping("/prac-get-all")
    public List<PracticesClass> getallPractice() {
        return classService.findAll();
    }
    
    @DeleteMapping("/del-prac")
    public String deletePractice(@RequestBody PracticesClass prac) {
    	classService.delete(prac.getId());
        return "deleted successfully";
    }
    
    @PutMapping("/update-prac")
    public ResponseEntity<PracticesClass> updatePractice(@RequestBody PracticesClass prac) {
        int id = classService.update(prac); 
        if (id > 0) {
            PracticesClass updatedPrac = classService.findById(prac.getId());
            return ResponseEntity.ok(updatedPrac); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
