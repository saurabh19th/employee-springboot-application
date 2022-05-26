package com.example.demo.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentId implements Serializable {
	
	private int rollno;
	private String section;
	
	public StudentId () {
		
	}
	
	public StudentId (int rollno,String section) {
		this.rollno = rollno;
		this.section = section;
	}

}
