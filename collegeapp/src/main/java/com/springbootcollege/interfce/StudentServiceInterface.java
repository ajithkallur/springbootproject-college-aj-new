package com.springbootcollege.interfce;

import java.util.List;

import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Section;
import com.springbootcollege.jpa.entities.Student;

public interface StudentServiceInterface {
	List<Student> findStudentsBySectionId(int id);
	Section findById(int id);
	List<Student> findAll();
	Student createStudent(Student student);
	Section assignSectionToStudent(int seid, int stid);
}
