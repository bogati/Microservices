package com.jump.controller;

//import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jump.model.Employee;
import com.jump.service.EmployeeService;

@RestController
@RequestMapping("employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping
	public Iterable<Employee> all() {
		logger.info("Find all employee information for GET: ");
		return employeeService.getEmployees();
	}
	
	@GetMapping("/{employeeId}")
	public Employee findEmployee(@PathVariable Integer employeeId) {
		logger.info("Find by Employee ID for GETBYID:" + employeeId);
		return employeeService.findEmployee(employeeId);
	}
	
	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		logger.info("Save employee for POST:" + employee);
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/{employeeId}")
	public Employee update(@PathVariable Integer employeeId, @RequestBody Employee employee) {
		logger.info("Find by employee for PUT: " + employee);
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<?> delete(@PathVariable Integer employeeId) {
		logger.info("Find by Employee ID for DELETE:" + employeeId);
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.noContent().build();
	}
	
	
}
