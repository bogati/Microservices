package com.jump.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jump.model.Employee;
import com.jump.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Iterable<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Employee findEmployee(Integer employeeId) {
		return employeeRepository.findByEmployeeId(employeeId);
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	// If an entry in table already exists with employee ID
	// It will update the existing entry when .save() is used
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(Integer employeeId) {
		findEmployee(employeeId);
		employeeRepository.deleteById(employeeId);
	}
}
