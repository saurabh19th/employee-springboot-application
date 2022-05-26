package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "employee")
public class Employee {
	
	@Id
	private int id;
	private String name;
	private int age;
	private String location;
	private String sex;
	private String phone;
	private Long salary;
	
	@ManyToOne
	private Department department;
	
	public Employee () {
		
	}

}
