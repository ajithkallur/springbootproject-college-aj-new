package com.springbootcollege.jpa.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	public Section getSection() {
		return section;
	}


	public void setSection(Section section) {
		this.section = section;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	private String email;
	
	@JsonIgnore	
	@ManyToOne
	private Section section;

	
	@ManyToMany(mappedBy = "students")
	private List<Project> projects;

	
	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void addPrjToStudent(Project pjt) {
		this.projects.add(pjt);
		
	}

}
