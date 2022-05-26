package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Data;

@Data
@IdClass(StudentId.class)
@Entity(name = "student")
public class Student {
	
	@Id
	private int rollno;
	@Id
	private String section;
	private String name;
	
	public Student() {
		
	}

}
