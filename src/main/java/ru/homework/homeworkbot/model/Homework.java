package ru.homework.homeworkbot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.lang.String;


@Setter
@Getter

@Entity
@Table(name = "homework")
public class Homework {

    //Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "description", nullable = false)
    private String description; //комментарии по дз

    @Column(name = "due_date", nullable = false)
    private LocalDateTime dueBye;

    @Column(name = "groupNumber")
    private String groupNumber;

    @Column(name = "added_by")
    private String addedBy; //добавлено кем,


    //Constructor
    public Homework(Long _id, String _subject, String _description, LocalDateTime _dueBy, String _groupNumber, String _addedBy){
        this.id = _id;
        this.subject = _subject;
        this.description = _description;
        this.dueBye = _dueBy;
        this.groupNumber = _groupNumber;
        this.addedBy = _addedBy;
    }

    public Homework(){}


    //срок
    public boolean isOverdue(){
        return dueBye.isBefore(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return String.format("Homework [ID: %d, Subject: %s, Due: %s]", id, subject, dueBye);
    }

    //сравнение дз по сроку
    public int compareTo(Homework other){
        return this.dueBye.compareTo(other.dueBye);
    }

    //method for reminders
    //methods for categorizing Homework



}
