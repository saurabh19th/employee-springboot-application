package com.example.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import com.example.demo.respositories.DepartmentRepository;
import com.example.demo.respositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional
	public Employee saveEmployee(Employee employee) {
		
		Department department = new Department();
		department.setDeptno(employee.getDepartment().getDeptno());
		department.setBudget(employee.getDepartment().getBudget());
		department.setBuildname(employee.getDepartment().getBuildname());
		department.setDeptname(employee.getDepartment().getDeptname());
		departmentRepository.save(department);
		employee = null;
		return employeeRepository.save(employee);
	}

}
