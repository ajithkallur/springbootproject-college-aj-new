package com.springbootcollege.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcollege.interfce.ProjectServiceInterface;
import com.springbootcollege.interfce.StudentServiceInterface;
import com.springbootcollege.jpa.dao.ProjectRepository;
import com.springbootcollege.jpa.dao.SectionRepository;
import com.springbootcollege.jpa.dao.StudentRepository;
import com.springbootcollege.jpa.entities.Project;
import com.springbootcollege.jpa.entities.Section;
import com.springbootcollege.jpa.entities.Student;


@Service
public class ProjectServiceImplementation implements ProjectServiceInterface{

	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	StudentRepository stuRepo;
	
	@Override
	public List<Project> findProjectsByStudentId(int id) {
		Student stu = stuRepo.findById(id).get();
		return stu.getProjects();
	}

	@Override
	public List<Project> findAll() {
		return proRepo.findAll();
	}

	@Override
	public Project findById(int id) {
		return proRepo.findById(id).get();
	}
	@Override
	public Project createProject(Project project) {
		return proRepo.save(project);
	}
	@Override
    public Student assignStudentToProject(int stid, int pid ) {		
		Student stu = stuRepo.findById(stid).get();
		Project prj = proRepo.findById(pid).get();
		prj.addStuToPrj(stu);
		 proRepo.save(prj);
		 return stu;
	}

}
