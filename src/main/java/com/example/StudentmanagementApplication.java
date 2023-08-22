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
		Student st7 = Student.builder().name("taka").email("t@gmail.com").build();
		Student st8 = Student.builder().name("poisa").email("p@gmail.com").build();
		Student st9 = Student.builder().name("mamata").email("mamu@gmail.com").build();
		Student st10 = Student.builder().name("vaipo").email("jali@gmail.com").build();
		Student st11 = Student.builder().name("pooja").email("p1@gmail.com").build();
		Student st12 = Student.builder().name("pooja").email("p2@gmail.com").build();
		Student st13 = Student.builder().name("pooja").email("p3@gmail.com").build();
		Student st14 = Student.builder().name("pooja").email("p@gmail.com").build();
		studentRepository.save(st1);
		studentRepository.save(st2);
		studentRepository.save(st3);
		studentRepository.save(st4);
		studentRepository.save(st5);
		studentRepository.save(st6);
		studentRepository.save(st7);
		studentRepository.save(st8);
		studentRepository.save(st9);
		studentRepository.save(st10);
		studentRepository.save(st11);
		studentRepository.save(st11);
		studentRepository.save(st12);
		studentRepository.save(st13);
		studentRepository.save(st14);

		System.out.println("------------------------------------all saved------------------------------");

	}

}
