package com.springbootcollege.jpa.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;



public interface CollegeRepository extends PagingAndSortingRepository<College, Integer> {

	Optional<College> findByName(String name);
	
    
}