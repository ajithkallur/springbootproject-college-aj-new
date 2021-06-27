package com.springbootcollege.jpa.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Project;
import com.springbootcollege.jpa.entities.Section;



public interface SectionRepository extends PagingAndSortingRepository<Section, Integer> {
    
	Optional<Section> findByRoomNumber(int num);
}