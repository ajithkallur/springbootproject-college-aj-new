package com.springbootcollege.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcollege.jpa.dao.DepartmentRepository;
import com.springbootcollege.jpa.entities.Department;
@RestController
public class CollegeController {

	@Autowired
	DepartmentRepository depRepo;
	
	@GetMapping(path = "/college/departments")
	public Iterable<Department> getDepartments(){
		return depRepo.findAll();
	}
}

