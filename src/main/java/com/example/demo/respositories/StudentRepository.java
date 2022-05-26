package com.example.demo.respositories;
import com.example.demo.models.Student;
import com.example.demo.models.StudentId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,StudentId> {

}
