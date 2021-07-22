package com.springboot.college.interfce;

import java.util.List;

import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;

public interface CollegeInterface {

	List<College> findByName(String name);
	College findById(int id);
	List<College> findAll();
	List<Department> findDepartmentsByCollegeId(int id);
	College createCollege(College college);
}
