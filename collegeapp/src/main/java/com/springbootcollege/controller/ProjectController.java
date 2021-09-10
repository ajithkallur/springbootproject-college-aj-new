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

import com.springbootcollege.interfce.ProjectServiceInterface;
import com.springbootcollege.jpa.dao.CollegeRepository;
import com.springbootcollege.jpa.dao.DepartmentRepository;
import com.springbootcollege.jpa.dao.ProjectRepository;
import com.springbootcollege.jpa.dao.SectionRepository;
import com.springbootcollege.jpa.dao.StudentRepository;
import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Project;
import com.springbootcollege.jpa.entities.Section;
import com.springbootcollege.jpa.entities.Student;

@RestController
public class ProjectController {

	@Autowired
	ProjectServiceInterface projectService;
	

	@GetMapping(path = "/colleges/departments/sections/students/projects")
	public Iterable<Project> getAllProjects(){
		return projectService.findAll();
	}
	
	@GetMapping(path = "/colleges/departments/sections/students/projects/id/{id}")
	public Project findProjectById( @PathVariable("id") int id){
		return projectService.findById(id);
	}
	
	@GetMapping(path = "/colleges/departments/sections/students/id/{id}/projects")
	public List<Project> findProjectsByStudentId( @PathVariable("id") int id){
		
		return projectService.findProjectsByStudentId(id);
	}
	@PostMapping(path = "/colleges/departments/sections/students/projects", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Project create(@RequestBody @Validated Project project) {
		return projectService.createProject(project);
	}
	
	@PutMapping(path = "/colleges/departments/sections/student/{stid}/project/{pid}", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Student assignStudentToProject(@PathVariable("stid") int stid, @PathVariable("pid") int pid ) {
				
		return projectService.assignStudentToProject(stid, pid);
	};
	
	
}

