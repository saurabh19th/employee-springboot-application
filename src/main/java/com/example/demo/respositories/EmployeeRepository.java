package com.example.demo.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
