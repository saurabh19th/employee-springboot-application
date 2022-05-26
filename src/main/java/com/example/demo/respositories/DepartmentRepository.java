package com.example.demo.respositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}
