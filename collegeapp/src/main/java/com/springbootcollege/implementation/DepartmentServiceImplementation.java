package com.springbootcollege.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootcollege.interfce.DepartmentServiceInterface;
import com.springbootcollege.jpa.dao.CollegeRepository;
import com.springbootcollege.jpa.dao.DepartmentRepository;
import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Section;


@Service
public class DepartmentServiceImplementation implements DepartmentServiceInterface{

	@Autowired
	DepartmentRepository depRepo;
	
	@Autowired
	CollegeRepository colRepo;
	
	@Override
	public List<Department> findByName(String name) {
		return depRepo.findByName(name);
	}

	@Override
	public List<Department> findAll() {
		return depRepo.findAll();
	}

	@Override
	public Department findById(int id) {
		return depRepo.findById(id).get();
	}

	@Override
	public List<Section> findSectionsByDepartmentId(int id) {
		Department dept = depRepo.findById(id).get();
		return dept.getSections();
	}

	@Override
	public Department createDepartment(Department department) {
		return depRepo.save(department);
	}
	@Override
    public College assignCollegeToDepartment(int cid, int did ) {
		
		College clg = colRepo.findById(cid).get();
		Department dpt = depRepo.findById(did).get();
		dpt.setCollege(clg);
		 depRepo.save(dpt);
		 return clg;
	}
	
}
