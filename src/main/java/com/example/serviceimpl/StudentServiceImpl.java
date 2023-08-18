package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.exception.StudentNotFoundException;
import com.example.repository.StudentRepository;
import com.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

//	public StudentServiceImpl(StudentRepository studentRepository) {
//		super();
//		this.studentRepository = studentRepository;
//	}

	@Override
	public Student newStudent(Student s) {
		return studentRepository.save(s);

	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();

	}

	@Override
	public Student getAStudent(int id) {
		java.util.Optional<Student> stDb = this.studentRepository.findById(id);

		if (stDb.isPresent()) {
			return stDb.get();
		} else {
			throw new StudentNotFoundException("Student not found with id : " + stDb);
		}
	}

//	// SEE THE BELOW VERSION OF SAME METHOD ....
//
//	// @Override
//	public Student getAStudent(int id) {
//		return studentRepository.findById(id)
//				.orElseThrow(() -> new StudentNotFoundException("Student not found with id : " + id));
//
//	}

	@Override
	public Student updateStudent(Student st, int id) {
		Student temp = getAStudent(id);
		temp.setEmail(st.getEmail());
		temp.setName(st.getName());
		return newStudent(temp);
	}

	@Override
	public String deleteStudent(int id) {
		Student temp = getAStudent(id);
		studentRepository.deleteById(temp.getId());
		return "The student with id " + id + " has been deleted!!!!!";
	}

	@Override
	public Student getByName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findByName(name);
	}

}
