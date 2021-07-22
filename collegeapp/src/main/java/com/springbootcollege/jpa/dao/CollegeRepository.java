package com.springbootcollege.jpa.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springbootcollege.jpa.entities.College;



public interface CollegeRepository extends JpaRepository<College, Integer> {

	List<College> findByName(String name);
	
    
}