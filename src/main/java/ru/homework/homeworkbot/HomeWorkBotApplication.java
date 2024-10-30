package ru.homework.homeworkbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import ru.homework.homeworkbot.model.Homework;
import ru.homework.homeworkbot.model.Student;
import ru.homework.homeworkbot.repository.HomeworkRepository;
import ru.homework.homeworkbot.repository.StudentRepository;


import java.time.LocalDateTime;
import java.util.List;


@SpringBootApplication
public class HomeWorkBotApplication implements CommandLineRunner {

	@Autowired
	private HomeworkRepository homeWorkRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HomeWorkBotApplication.class, args);



	}

	@Override
	public void run(String... args) throws Exception {
		// Create and save a new homework entry
		Homework homework = new Homework(1L, "Math",
				"Complete Algebra homework", LocalDateTime.of(2024, 10, 30, 23, 45),
				"KH-203", "Mr. John Doe"  );
		homeWorkRepository.save(homework);

		// Create and save a new student
		Student student = new Student("Grigory Shkitin", "KH-203", 2, 1234L);
		studentRepository.save(student);

		// Fetch all homework entries
		List<Homework> homeworks = homeWorkRepository.findAll();
		System.out.println("Homework List: " + homeworks);

		// Fetch all student entries
		List<Student> students = studentRepository.findAll();
		System.out.println("Student List: " + students);
	}
}

