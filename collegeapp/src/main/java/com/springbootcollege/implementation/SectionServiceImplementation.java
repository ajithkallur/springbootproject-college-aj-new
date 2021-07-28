package com.springbootcollege.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootcollege.interfce.DepartmentServiceInterface;
import com.springbootcollege.interfce.SectionServiceInterface;
import com.springbootcollege.jpa.dao.CollegeRepository;
import com.springbootcollege.jpa.dao.DepartmentRepository;
import com.springbootcollege.jpa.dao.SectionRepository;
import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Section;


@Service
public class SectionServiceImplementation implements SectionServiceInterface{

	@Autowired
	SectionRepository secRepo;
	
	@Autowired
	DepartmentRepository depRepo;
	
	@Override
	public List<Section> findSectionByRoomNumber(int num) {
		return secRepo.findByRoomNumber(num);
	}

	@Override
	public List<Section> findAll() {
		return secRepo.findAll();
	}

	@Override
	public Section findById(int id) {
		return secRepo.findById(id).get();
	}
	@Override
	public Section createSection(Section department) {
		return secRepo.save(department);
	}
	@Override
    public Department assignDepartmentToSection(int did, int seid ) {		
Department dpt = depRepo.findById(did).get();
Section sec = secRepo.findById(seid).get();
sec.setDepartment(dpt);
 secRepo.save(sec);
 return dpt;
	}
	
}
