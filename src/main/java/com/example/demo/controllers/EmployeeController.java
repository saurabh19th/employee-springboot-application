package com.example.demo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.respositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import com.example.demo.models.Employee;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> list() {
		logger.trace("Getting All Employee Details");
		return employeeRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Employee get(@PathVariable Integer id ) {
		logger.trace("Getting Employee Details With Id : "+id);
		return employeeRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Employee create(@RequestBody Employee employee) {
		logger.trace("Storing Employee Details");
		return employeeRepository.save(employee);
	}
	
	@PostMapping("/transaction")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Employee transaction(@RequestBody Employee employee) {
		logger.trace("Executing Transaction");
		return employeeService.saveEmployee(employee);
	}
	
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable Integer id) {
		logger.trace("Deleting Employee Details With Id : "+id);
		employeeRepository.deleteById(id);
	}
	
	@PutMapping(value = "{id}")
	public Employee update(@PathVariable Integer id,@RequestBody Employee employee) {
		logger.trace("Updating Employee Details With Id : "+id);
		Employee existingEmployee = employeeRepository.getById(id);
		BeanUtils.copyProperties(employee, existingEmployee);
		return employeeRepository.save(existingEmployee);
	}

}
