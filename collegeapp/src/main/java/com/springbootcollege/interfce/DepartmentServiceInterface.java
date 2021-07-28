package com.springbootcollege.interfce;

import java.util.List;

import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Section;

public interface DepartmentServiceInterface {
	List<Department> findByName(String name);
	Department findById(int id);
	List<Department> findAll();
	Department createDepartment(Department department);
	List<Section> findSectionsByDepartmentId(int id);
	College assignCollegeToDepartment(int cid, int did);
}
