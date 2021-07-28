package com.springbootcollege.interfce;

import java.util.List;

import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Section;

public interface SectionServiceInterface {
	List<Section> findSectionByRoomNumber(int num);
	Section findById(int id);
	List<Section> findAll();
	Section createSection(Section section);
	Department assignDepartmentToSection(int cid, int did);
}
