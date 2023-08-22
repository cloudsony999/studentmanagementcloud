package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.entity.Student;

@Component
public interface StudentService {

	Student newStudent(Student s);

	List<Student> getAll();

	Student getAStudent(int id);

	Student updateStudent(Student st, int id);

	String deleteStudent(int id);

	Student getByName(String name);

	// it offers page of students in a sorted manner
	Page<Student> getStudentPagination(Integer pageNumber, Integer pageSize, String sort);

	List<Student> getByNameAndEmail(String name, String email);
}
