package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@SpringBootApplication
public class StudentmanagementApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student st1 = Student.builder().name("pooja").email("p@gmail.com").build();
		Student st2 = Student.builder().name("bipasha").email("b@gmail.com").build();
		Student st3 = Student.builder().name("kamalika").email("k@gmail.com").build();
		Student st4 = Student.builder().name("rittika").email("r@gmail.com").build();
		Student st5 = Student.builder().name("amitava").email("a@gmail.com").build();
		Student st6 = Student.builder().name("sankha").email("sk@gmail.com").build();
		studentRepository.save(st1);
		studentRepository.save(st2);
		studentRepository.save(st3);
		studentRepository.save(st4);
		studentRepository.save(st5);
		studentRepository.save(st6);
		System.out.println("------------------------------------all saved------------------------------");

	}

}
