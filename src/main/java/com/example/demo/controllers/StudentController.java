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

import com.example.demo.models.Student;
import com.example.demo.models.StudentId;
import com.example.demo.respositories.StudentRepository;

@RestController
@RequestMapping("student")
public class StudentController {
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping
	public List<Student> list() {
		logger.trace("Getting All Student Details");
		return studentRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Student get(@PathVariable StudentId id ) {
		logger.trace("Getting Student Details With Id : "+id);
		return studentRepository.findById(id).get();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Student create(@RequestBody Student student) {
		logger.trace("Storing Student Details");
		return studentRepository.save(student);
	}
	
	@DeleteMapping(value = "{id}")
	public void delete(@PathVariable StudentId id) {
		logger.trace("Deleting Student Details With Id : "+id);
		studentRepository.deleteById(id);
	}
	
	@PutMapping(value = "{id}")
	public Student update(@PathVariable StudentId id,@RequestBody Student student) {
		logger.trace("Updating Student Details With Id : "+id);
		Student existingStudent = studentRepository.getById(id);
		BeanUtils.copyProperties(student, existingStudent);
		return studentRepository.save(existingStudent);
	}

}
