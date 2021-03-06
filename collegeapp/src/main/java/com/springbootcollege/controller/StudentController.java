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

import com.springbootcollege.interfce.SectionServiceInterface;
import com.springbootcollege.interfce.StudentServiceInterface;
import com.springbootcollege.jpa.dao.CollegeRepository;
import com.springbootcollege.jpa.dao.DepartmentRepository;
import com.springbootcollege.jpa.dao.SectionRepository;
import com.springbootcollege.jpa.dao.StudentRepository;
import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Project;
import com.springbootcollege.jpa.entities.Section;
import com.springbootcollege.jpa.entities.Student;

@RestController
public class StudentController {

	@Autowired
	StudentServiceInterface studentService;
	
	@Autowired
	SectionRepository secRepo;
	
	
	
	@GetMapping(path = "/colleges/departments/sections/students")
	public Iterable<Student> getAllStudents(){
		return studentService.findAll();
	}
	
	@GetMapping(path = "/colleges/departments/sections/students/id/{id}")
	public Student findStudentById( @PathVariable("id") int id){
		return studentService.findById(id);
	}
	
	@GetMapping(path = "/colleges/departments/sections/id/{id}/students")
	public List<Student> findStudentsBySectionId( @PathVariable("id") int id){
		
		return studentService.findStudentsBySectionId(id);
	}
	@PostMapping(path = "/colleges/departments/sections/students", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Student create(@RequestBody @Validated Student student) {
		return studentService.createStudent(student);
	}
	
	@PutMapping(path = "/colleges/departments/section/{seid}/student/{stid}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Section assignSectionToStudent(@PathVariable("seid") int seid, @PathVariable("stid") int stid ) {		
	 return studentService.assignSectionToStudent(seid, stid);
	}
}

