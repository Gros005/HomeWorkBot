package ru.homework.homeworkbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.homework.homeworkbot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // No methods to add, CRUD(Create, Read, Update, Delete are all available via Spring
    //Also available are save(), findAll(), findById(), deletebyId()
}
