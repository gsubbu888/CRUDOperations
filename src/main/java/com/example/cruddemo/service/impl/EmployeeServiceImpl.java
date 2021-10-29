package com.example.cruddemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.repository.EmployeeRepository;
import com.example.cruddemo.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository empRepository;
	
	@Override
	public Employee addEmployee(Employee emp)
	{
		return empRepository.save(emp);
	}
	
	@Override
	public List<Employee> getAllEmployees()
	{
		return empRepository.findAll();
	}
	
	@Override
	public Employee getUserById(Long id)
	{
		return empRepository.findById(id).get();
	}

	@Override
	public String deleteUserById(Long id) {
		empRepository.deleteById(id);
		return "Success";
	}

	@Override
	public Employee updateEmployee(Employee emp,Long id) {
		Employee emp1=empRepository.findById(id).get();
		emp1.setFirstName(emp.getFirstName());
		emp1.setLastName(emp.getLastName());
		emp1.setDesignation(emp.getDesignation());
		return empRepository.save(emp1);
	}
	
	@Override
	public List<Employee> getEmployeesByDesignation(String Designation){
		return empRepository.findByDesignation(Designation);
	}

	@Override
	public List<Employee> getEmployeesByFirstName(String firstName) {
		List<Employee> employees = empRepository.findByFirstName(firstName);
		
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByName(String firstName, String lastName) {
		List<Employee> employees = empRepository.findByFirstNameAndLastName(firstName, lastName);
		
		return employees;
	}
	
	@Override
	public List<Employee> getEmployeesByOrName(String firstName, String lastName) {
				
		List<Employee> employees = empRepository.findByFirstNameOrLastName(firstName, lastName);
		//List<Employee> employees = empRepository.findByFirstNameContainsOrLastNameContains(firstName, lastName);
		return employees;
	}
	
	@Override
	public List<Employee> getEmployeesByContainsName(String firstName, String lastName) {
				
		List<Employee> employees = empRepository.findByFirstNameContainsOrLastNameContains(firstName, lastName);
		return employees;
	}
	
	@Override
	public List<Employee> getEmployeesBySqlName(String firstName, String lastName) {
		List<Employee> employees = empRepository.getEmployeesByName(firstName, lastName);
		
		return employees;
	}
	
	@Override
	public List<Employee> getEmployeesOrderByNamePageable(String firstName, String lastName) {
		
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
		List<Employee> employees = empRepository.findByFirstNameContainsOrderByFirstNameAsc(firstName, firstPageWithTwoElements);
		
		return employees;
	}
	
}
