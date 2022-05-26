package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity(name = "department")
public class Department {
	
	@Id
	private int deptno;
	private String deptname;
	private String buildname;
	private Long budget;
	
	@OneToMany(mappedBy = "department")
	@JsonIgnore
	private List<Employee> employees;
	
	public Department () {
		
	}

}
