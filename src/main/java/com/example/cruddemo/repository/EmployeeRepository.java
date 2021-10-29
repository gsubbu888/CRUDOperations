package com.example.cruddemo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cruddemo.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findByDesignation(String designation);
	
	List<Employee> findByFirstName(String firstName);
	
    List<Employee> findByFirstNameContainsOrderByFirstNameAsc(String firstName);
	
	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
	
	@Query("from Employee where firstName=:firstName and lastName=:lastName")
	List<Employee> getEmployeesByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	@Query(value = "select e from Employee e where e.first_name = :firstName and e.last_name = :lastName", nativeQuery = true)
	List<Employee> getEmployeesByNameSql(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	List<Employee> findByFirstNameOrLastName(String firstName, String lastName);
	
	List<Employee> findByFirstNameContainsOrLastNameContains(String firstName, String lastName);

	List<Employee> findByFirstNameContainsOrderByFirstNameAsc(String firstName, Pageable pageable);

	
}
