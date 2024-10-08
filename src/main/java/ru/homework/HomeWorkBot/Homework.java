package ru.homework.HomeWorkBot;

import lombok.Getter;
import lombok.Setter;

import java.security.PublicKey;
import java.util.*;
import java.lang.String;

@Setter
@Getter
public class Homework {
    private Long id;
    private String subject;
    private String description; //комментарии по дз
    private Date dueDate;
    private int groupNumber;
    private Long addedBy; //добавлено кем,


    //Constructor
    public Homework(Long _id, String _subject, String _description, Date _dueDate, int _groupNumber, Long _addedBy){
        this.id = _id;
        this.subject = _subject;
        this.description = _description;
        this.dueDate = _dueDate;
        this.groupNumber = _groupNumber;
        this.addedBy = _addedBy;
    }


    //Getters
    public Long getId(){
        return id;
    }
    public String getSubject(){
        return subject;
    }
    public String getDescription(){
        return description;
    }
    public Date getDueDate(){
        return dueDate;
    }
    public int getGroupNumber(){
        return groupNumber;
    }
    public Long getAddedBy(){
        return addedBy;
    }

    public boolean isOverdue(){
        return dueDate.before(new Date());

    }

    @Override
    public String toString() {
        return String.format("Homework [ID: %d, Subject: %s, Due: %s]", id, subject, dueDate);
    }
    //сравнение дз по сроку
    public int compareTo(Homework other){
        return this.dueDate.compareTo(other.dueDate);
    }
    //method for reminders
    //methods for categorizing Homework



}
