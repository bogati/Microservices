package com.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jump.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findByEmployeeId(Integer employeeId);
	
}
