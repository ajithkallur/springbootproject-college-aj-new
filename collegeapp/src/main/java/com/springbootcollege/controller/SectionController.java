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

import com.springbootcollege.interfce.SectionServiceInterface;
import com.springbootcollege.jpa.dao.DepartmentRepository;
import com.springbootcollege.jpa.dao.SectionRepository;
import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Section;

@RestController
public class SectionController {

	@Autowired
	SectionServiceInterface sectionService;
	
	@GetMapping(path = "/colleges/departments/sections")
	public List<Section> getAllSections(){
		return sectionService.findAll();
	}
	
	@GetMapping(path = "/colleges/departments/sections/id/{id}")
	public Section findSectionById( @PathVariable("id") int id){
		return sectionService.findById(id);
	}
	
	@GetMapping(path = "/colleges/departments/sections/roomnumber/{num}")
	public List<Section> findSectionByRoomNumber( @PathVariable("num") int num){
		return sectionService.findSectionByRoomNumber(num);
	}

	
	@PostMapping(path = "/colleges/departments/sections", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Section create(@RequestBody @Validated Section section) {
		return sectionService.createSection(section);
	}
	
	@PutMapping(path = "/colleges/department/{did}/section/{seid}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Department assignDepartmentToSection(@PathVariable("did") int did, @PathVariable("seid") int seid ) {
	return sectionService.assignDepartmentToSection(did,seid);
	}
	
}

