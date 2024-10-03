package ru.homework.HomeWorkBot;

import java.util.*;
import java.lang.String;

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

    //Setters
    public void setId(Long _id){
        if(_id != null && _id > 0){
            this.id = _id;
        } else{
            throw new IllegalArgumentException("ID must be > 0");
        }
    }

    public void setSubject(String _subject){
        if(_subject != null && _subject.isEmpty()){
            this.subject = _subject;
        } else{
            throw new IllegalArgumentException("Enter correct string");
        }
    }

    public void setDescription(String _description){
        if(_description != null && !_description.isEmpty()  && _description.length() < 50){
            this.description = _description;
        } else{
            throw new IllegalArgumentException("Enter description again");
        }
    }

    public void setDueDate(Date _dueDate){
        if(_dueDate != null){
            this.dueDate = _dueDate;
        } else{
            throw new IllegalArgumentException("dueDate must not be null");
        }
    }

    public void setGroupNumber(int _groupNumber){
        if(_groupNumber != 0){
            this.groupNumber = _groupNumber;
        } else{
            throw new IllegalArgumentException("groupNumber ");
        }
    }

    public void setAddedBy(Long _addedBy){
        if(_addedBy != null){
            this.addedBy = _addedBy;
        } else{
            throw new IllegalArgumentException("ID must be > 0");
        }
    }
}
