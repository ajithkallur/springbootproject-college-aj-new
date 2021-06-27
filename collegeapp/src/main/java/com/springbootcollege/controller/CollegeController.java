package com.springbootcollege.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcollege.jpa.dao.CollegeRepository;
import com.springbootcollege.jpa.dao.DepartmentRepository;
import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
@RestController
public class CollegeController {
	
	
	@Autowired
	CollegeRepository collRepo;

	
	@GetMapping(path = "/colleges")
	public Iterable<College> getAllColleges(){
		return collRepo.findAll();
	}
	
	@GetMapping(path = "/colleges/id/{id}")
	public College findCollegeById( @PathVariable("id") int id){
		return collRepo.findById(id).get();
	}
	
	@GetMapping(path = "/colleges/name/{name}")
	public Optional<College> findCollegeByName( @PathVariable("name") String name){
		return collRepo.findByName(name);
	}
	
	@GetMapping(path = "/colleges/id/{id}/departments")
	public Set<Department> findDepartmentsByCollegeId( @PathVariable("id") int id){
		
		College clg = collRepo.findById(id).get();
		return clg.getDepartments();
	}
	
	
	@PostMapping(path = "/colleges", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public College create(@RequestBody @Validated College college) {
		return collRepo.save(college);
	}
	
	
}

