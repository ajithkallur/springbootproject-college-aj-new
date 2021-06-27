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
import com.springbootcollege.jpa.dao.SectionRepository;
import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Section;
import com.springbootcollege.jpa.entities.Student;
//import com.springbootcollege.jpa.entities.Student;
@RestController
public class SectionController {

	@Autowired
	SectionRepository secRepo;
	
	@Autowired
	DepartmentRepository depRepo;
	
	
	@GetMapping(path = "/colleges/departments/sections")
	public Iterable<Section> getAllDepartments(){
		return secRepo.findAll();
	}
	
	@GetMapping(path = "/colleges/departments/sections/id/{id}")
	public Section findDepartmentById( @PathVariable("id") int id){
		return secRepo.findById(id).get();
	}
	
	@GetMapping(path = "/colleges/departments/sections/roomnumber/{num}")
	public Optional<Section> findDepartmentByName( @PathVariable("num") int num){
		return secRepo.findByRoomNumber(num);
	}

	@GetMapping(path = "/colleges/departments/sections/id/{id}/students")
	public List<Student> findStudentsBySectionId( @PathVariable("id") int id){
		
		Section sect = secRepo.findById(id).get();
		return sect.getStudents();
	}
	
	@PostMapping(path = "/colleges/departments/sections", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Section create(@RequestBody @Validated Section section) {
		return secRepo.save(section);
	}
	
	@PutMapping(path = "/colleges/department/{did}/section/{seid}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Department assignDepartmentToSection(@PathVariable("did") int did, @PathVariable("seid") int seid ) {
				
	Department dpt = depRepo.findById(did).get();
	Section sec = secRepo.findById(seid).get();
	sec.setDepartment(dpt);
	 secRepo.save(sec);
	 return dpt;
	}
	
}

