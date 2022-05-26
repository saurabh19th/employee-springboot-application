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

import com.example.demo.models.Department;
import com.example.demo.respositories.DepartmentRepository;

@RestController
@RequestMapping("department")
public class DepartmentController {
	
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping
	public List<Department> list() {
		logger.trace("Getting All Department Details");
		return departmentRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Department get(@PathVariable Integer deptno ) {
		logger.trace("Getting Department Details With Dept.No : "+deptno);
		return departmentRepository.findById(deptno).get();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Department create(@RequestBody Department department) {
		logger.trace("Storing Department Details");
		return departmentRepository.save(department);
	}
	
	@DeleteMapping(value = "{deptno}")
	public void delete(@PathVariable Integer deptno) {
		logger.trace("Deleting Department Details With Dept.No : "+deptno);
		departmentRepository.deleteById(deptno);
	}
	
	@PutMapping(value = "{deptno}")
	public Department update(@PathVariable Integer deptno,@RequestBody Department department) {
		logger.trace("Updating Department Details With Dept.No : "+deptno);;
		Department existingDepartment = departmentRepository.getById(deptno);
		BeanUtils.copyProperties(department, existingDepartment);
		return departmentRepository.save(existingDepartment);
	}

}
