package com.springbootcollege.interfce;

import java.util.List;

import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Project;
import com.springbootcollege.jpa.entities.Section;
import com.springbootcollege.jpa.entities.Student;

public interface ProjectServiceInterface {
	Project findById(int id);
	List<Project> findAll();
	Project createProject(Project project);
	List<Project> findProjectsByStudentId(int id);
	Student assignStudentToProject(int stid, int pid);
}
