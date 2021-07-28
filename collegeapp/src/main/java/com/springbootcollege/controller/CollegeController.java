package com.springbootcollege.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcollege.interfce.CollegeServiceInterface;
import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
@RestController
public class CollegeController {
	
	
	@Autowired
	CollegeServiceInterface collegeService;

	
	@GetMapping(path = "/colleges")
	public List<College> getAllColleges(){
		return collegeService.findAll();
	}
	
	@GetMapping(path = "/colleges/id/{id}")
	public College findCollegeById( @PathVariable("id") int id){
		return collegeService.findById(id);
	}
	
	@GetMapping(path = "/colleges/name/{name}")
	public List<College> findCollegeByName( @PathVariable("name") String name){
		return collegeService.findByName(name);
	}
	
	@GetMapping(path = "/colleges/id/{id}/departments")
	public List<Department> findDepartmentsByCollegeId( @PathVariable("id") int id){
		return collegeService.findDepartmentsByCollegeId(id);	
	}
	
	@PostMapping(path = "/colleges", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public College create(@RequestBody @Validated College college) {
		return collegeService.createCollege(college);
	}
	
	
}

