package com.springbootcollege.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.springbootcollege.jpa.entities.Section;
@RestController
public class DepartmentController {

	@Autowired
	DepartmentRepository depRepo;
	
	@Autowired
	CollegeRepository colRepo;
	
	
	@GetMapping(path = "/colleges/departments")
	public Iterable<Department> getAllDepartments(){
		return depRepo.findAll();
	}
	
	@GetMapping(path = "/colleges/departments/id/{id}")
	public Department findDepartmentById( @PathVariable("id") int id){
		return depRepo.findById(id).get();
	}
	
	@GetMapping(path = "/colleges/departments/name/{name}")
	public List<Department> findDepartmentByName( @PathVariable("name") String name){
		return depRepo.findByName(name);
	}

	@GetMapping(path = "/colleges/departments/id/{id}/sections")
	public List<Section> findSectionsByDepartmentId( @PathVariable("id") int id){
		
		Department dept = depRepo.findById(id).get();
		return dept.getSections();
	}
	
	@PostMapping(path = "/colleges/departments", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Department create(@RequestBody @Validated Department department) {
		return depRepo.save(department);
	}
	
	@PutMapping(path = "/colleges/departments", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Department update(@RequestBody @Validated Department department) {
		return depRepo.save(department);
	}
	
	
	@PutMapping(path = "/college/{cid}/department/{did}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public College assignCollegeToDepartment(@PathVariable("cid") int cid, @PathVariable("did") int did ) {
		
		College clg = colRepo.findById(cid).get();
		Department dpt = depRepo.findById(did).get();
		dpt.setCollege(clg);
		 depRepo.save(dpt);
		 return clg;
	}
	
}

