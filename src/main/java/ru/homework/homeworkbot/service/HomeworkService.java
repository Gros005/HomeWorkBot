package ru.homework.homeworkbot.service;


import org.springframework.stereotype.Service;
import ru.homework.homeworkbot.model.Homework;
import ru.homework.homeworkbot.repository.HomeworkRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HomeworkService {

    private final HomeworkRepository homeWorkRepository;

    public HomeworkService(HomeworkRepository homeWorkRepository){
        this.homeWorkRepository = homeWorkRepository;
    }

    public Homework saveHomework(Homework homework){
        return homeWorkRepository.save(homework);
    }

    public List<Homework> getAllHomework(){
        return homeWorkRepository.findAll();
    }

    public Optional<Homework> getHomeworkById(Long id){
        return homeWorkRepository.findById(id);

    }

    public void deleteHomework(Long id){
        homeWorkRepository.deleteById(id);
    }




}
