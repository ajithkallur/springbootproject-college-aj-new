package com.springbootcollege.jpa.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.springbootcollege.jpa.entities.College;
import com.springbootcollege.jpa.entities.Department;



public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	List<Department> findByName(String name);
    
}