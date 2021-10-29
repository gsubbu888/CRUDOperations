package com.example.cruddemo.service;

import java.util.List;

import com.example.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee emp);
	
	public List<Employee> getAllEmployees();
	
	public Employee getUserById(Long id);

	public String deleteUserById(Long id);
	
	public Employee updateEmployee(Employee emp,Long id);
	
	public List<Employee> getEmployeesByDesignation(String designation);
	
	public List<Employee> getEmployeesByName(String firstName, String lastName);
	
	public List<Employee> getEmployeesByFirstName(String firstName);
	
	public List<Employee> getEmployeesOrderByNamePageable(String firstName, String lastName);
	
	public List<Employee> getEmployeesBySqlName(String firstName, String lastName);
	
	public List<Employee> getEmployeesByContainsName(String firstName, String lastName);
	
	public List<Employee> getEmployeesByOrName(String firstName, String lastName);
}
