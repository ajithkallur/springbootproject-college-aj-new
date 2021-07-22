package com.springbootcollege.jpa.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.springbootcollege.jpa.entities.Department;
import com.springbootcollege.jpa.entities.Project;



public interface ProjectRepository extends JpaRepository<Project, Integer> {
    
}