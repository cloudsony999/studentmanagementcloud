package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/studentb")
	public ResponseEntity<Student> saveNewStudent(@RequestBody @Valid Student s) {
		try {
			Student str = studentService.newStudent(new Student(s.getName(), s.getEmail()));
			return new ResponseEntity<>(str, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/studentb")
	public ResponseEntity<List<Student>> showAllStudents() {

		try {
			List<Student> stall = new ArrayList<>();

			studentService.getAll().forEach(stall::add);

			if (stall.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(stall, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/studentbS/{id}")
	public ResponseEntity<Student> fetchAStudent(@PathVariable int id) {
		return ResponseEntity.ok().body(studentService.getAStudent(id));
	}

	@GetMapping("/studentName")
	public ResponseEntity<Student> fetchAStudentByName(@RequestParam String name) {
		return ResponseEntity.ok().body(studentService.getByName(name));
	}

}
