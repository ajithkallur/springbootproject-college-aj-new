package com.springboot.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.college.interfce.CollegeInterface;
import com.springbootcollege.jpa.dao.CollegeRepository;
import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;




@Service
public class CollegeImplementation implements CollegeInterface{

	@Autowired
	CollegeRepository collRepo;
	
	
	@Override
	public List<College> findByName(String name) {
		return collRepo.findByName(name);
	}

	@Override
	public List<College> findAll() {
		return collRepo.findAll();
	}

	@Override
	public College findById(int id) {
		return collRepo.findById(id).get();
	}

	@Override
	public List<Department> findDepartmentsByCollegeId(int id) {
		College clg = collRepo.findById(id).get();
		return clg.getDepartments();
	}

	@Override
	public College createCollege(College college) {
		// TODO Auto-generated method stub
		return collRepo.save(college);
	}

}
