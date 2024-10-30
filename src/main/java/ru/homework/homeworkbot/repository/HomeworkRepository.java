package ru.homework.homeworkbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.homework.homeworkbot.model.Homework;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
    // No methods to add, CRUD(Create, Read, Update, Delete are all available via Spring
    //Also available are save(), findAll(), findById(), deletebyId()
}
