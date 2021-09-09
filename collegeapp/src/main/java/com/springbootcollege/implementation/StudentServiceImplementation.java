package com.springbootcollege.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootcollege.interfce.StudentServiceInterface;
import com.springbootcollege.jpa.dao.SectionRepository;
import com.springbootcollege.jpa.dao.StudentRepository;
import com.springbootcollege.jpa.entities.Section;
import com.springbootcollege.jpa.entities.Student;


@Service
public class StudentServiceImplementation implements StudentServiceInterface{

	@Autowired
	StudentRepository stuRepo;
	
	@Autowired
	SectionRepository secRepo;
	
	@Override
	public List<Student> findStudentsBySectionId(int id) {
		Section sect = secRepo.findById(id).get();
		return sect.getStudents();
	}

	@Override
	public List<Student> findAll() {
		return stuRepo.findAll();
	}

	@Override
	public Student findById(int id) {
		return stuRepo.findById(id).get();
	}
	@Override
	public Student createStudent(Student student) {
		return stuRepo.save(student);
	}
	@Override
    public Section assignSectionToStudent(int seid, int stid ) {		
		Section sec = secRepo.findById(seid).get();
		Student stu = stuRepo.findById(stid).get();
		stu.setSection(sec);
		 stuRepo.save(stu);
		 return sec;
	}
	
}
