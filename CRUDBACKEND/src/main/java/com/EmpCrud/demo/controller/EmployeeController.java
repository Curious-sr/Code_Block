package com.EmpCrud.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.EmpCrud.demo.repository.EmployeeRepository;
import com.EmpCrud.demo.exception.ResourceNotFoundException;
import com.EmpCrud.demo.model.Employee;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// Get all Employees 
	@GetMapping("/employees")
	public List<Employee> getAllEployee(){
		
			return employeeRepository.findAll();

	}
	
	//Create Employee Restapi
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee emp) {
		return employeeRepository.save(emp);	
	}
	
	//Get Employee By Id rest Api
	
	@GetMapping("employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id) {
		
		Optional<Employee> employee = employeeRepository.findById(id);
		return ResponseEntity.ok(employee);
		
	}
	
	//Update Employee Rest Api
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
	    Optional<Employee> optionalEmployee = employeeRepository.findById(id);

	    if (optionalEmployee.isPresent()) {
	        Employee existingEmployee = optionalEmployee.get();
	        existingEmployee.setFirstName(employeeDetails.getFirstName());
	        existingEmployee.setLastName(employeeDetails.getLastName());
	        existingEmployee.setEmailId(employeeDetails.getEmailId());

	        Employee updatedEmployee = employeeRepository.save(existingEmployee);
	        return ResponseEntity.ok(updatedEmployee);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	//Delete Rest api call
	 @DeleteMapping("/employees/{id}")
	    public Map<String, Boolean> deleteEmployee(@PathVariable Long id) {
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        Map<String, Boolean> response = new HashMap<>();

	        if (optionalEmployee.isPresent()) {
	            Employee employeeToDelete = optionalEmployee.get();
	            employeeRepository.delete(employeeToDelete);
	            response.put("deleted", Boolean.TRUE);
	        } else {
	            response.put("deleted", Boolean.FALSE);
	        }

	        return response;
	    }
	
	

}
