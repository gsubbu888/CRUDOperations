package com.example.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee emp) {
		return empService.addEmployee(emp);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	
	@GetMapping("/{id}") 
	public Employee getUserById(@PathVariable Long id) {
		return empService.getUserById(id); 
	}
	 
	
	@GetMapping("/emp/{designation}")
	public List<Employee> getEmployeesByDesignation(@PathVariable String  designation) {
		return empService.getEmployeesByDesignation(designation);
	}
	
		
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable Long id) {
		 return empService.deleteUserById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee emp,@PathVariable Long id) {
		return empService.updateEmployee(emp,id);
	}
	
	@GetMapping("/emp/{firstName}")
	public List<Employee> getEmployeesByName(@PathVariable String  firstName) {
		return empService.getEmployeesByFirstName(firstName);
	}
	
	@GetMapping("/emp/{firstName}/{lastName}")
	public List<Employee> getEmployeesByName(@PathVariable String  firstName, @PathVariable String  lastName) {
		return empService.getEmployeesByName(firstName,lastName);
	}
	
	

}
