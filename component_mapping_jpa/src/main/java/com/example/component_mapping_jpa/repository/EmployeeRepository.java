package com.example.component_mapping_jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.component_mapping_jpa.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
}
