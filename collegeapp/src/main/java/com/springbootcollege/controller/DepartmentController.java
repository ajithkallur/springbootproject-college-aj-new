package com.springbootcollege.controller;

import java.util.List;
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

import com.springbootcollege.interfce.DepartmentServiceInterface;
import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Section;
@RestController
public class DepartmentController {

	@Autowired
	DepartmentServiceInterface departmentService;	
	
	@GetMapping(path = "/colleges/departments")
	public List<Department> getAllDepartments(){
		return departmentService.findAll();
	}
	
	@GetMapping(path = "/colleges/departments/id/{id}")
	public Department findDepartmentById( @PathVariable("id") int id){
		return departmentService.findById(id);
	}
	
	@GetMapping(path = "/colleges/departments/name/{name}")
	public List<Department> findDepartmentByName( @PathVariable("name") String name){
		return departmentService.findByName(name);
	}

	@GetMapping(path = "/colleges/departments/id/{id}/sections")
	public List<Section> findSectionsByDepartmentId( @PathVariable("id") int id){
		
		return departmentService.findSectionsByDepartmentId(id);
	}
	
	@PostMapping(path = "/colleges/departments", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Department create(@RequestBody @Validated Department department) {
		return departmentService.createDepartment(department);
	}
	
	@PutMapping(path = "/college/{cid}/department/{did}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public College assignCollegeToDepartment(@PathVariable("cid") int cid, @PathVariable("did") int did ) {
		 return departmentService.assignCollegeToDepartment(cid,did);
	}
	
}

