package ru.homework.homeworkbot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "group_number")
    private String groupNumber;

    @Column(name = "year_of_study")
    private int yearOfStudy;

    @Column(name = "student_id")
    private Long studentID;

    public Student(String _name, String _groupNumber, int _yearOfStudy, Long _studentID){
        this.name = _name;
        this.groupNumber = _groupNumber;
        this.yearOfStudy = _yearOfStudy;
        this.studentID = _studentID;
    }

    public Student(){}

    public boolean isEnrolledInGroup(String groupNumber){
        if(this.groupNumber.equals(groupNumber)){
            System.out.println(this.name + " is Enrolled in group " + this.groupNumber + " year " + this.yearOfStudy);
            return true;
        }
        return false;
    }

    public boolean isEnrolledInGroup(String groupNumber, int yearOfStudy){
        if(this.groupNumber.equals(groupNumber) && this.yearOfStudy == yearOfStudy){
            System.out.println(this.name + " is Enrolled in group " + this.groupNumber + " year " + this.yearOfStudy);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Student [ID: %d, Name: %s, Group: %s, Year: %d]", studentID, name, groupNumber, yearOfStudy);
    }







}
