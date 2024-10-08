package ru.homework.HomeWorkBot;

import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;
@Getter
@Setter
public class Student {

    private String name;
    private Long groupNumber;
    private int yearOfStudy;
    private Long studentID;

    public Student(String _name, Long _groupNumber, int _yearOfStudy, Long _studentID){
        this.name = _name;
        this.groupNumber = _groupNumber;
        this.yearOfStudy = _yearOfStudy;
        this.studentID = _studentID;
    }

    public boolean isEnrolledInGroup(Long groupNumber){
        if(this.groupNumber.equals(groupNumber)){
            System.out.println(this.name + " is Enrolled in group " + this.groupNumber + " year " + this.yearOfStudy);
            return true;
        }
        return false;
    }

    /*
      public boolean isEnrolledInGroup(Long groupNumber, int yearOfStudy){
        if(this.groupNumber.equals(groupNumber)) && this.yearOfStudy == yearOfStudy){
            System.out.println(this.name + " is Enrolled in group " + this.groupNumber + " year " + this.yearOfStudy);
            return true;
        }
        return false;
    }
    /*
     */

    @Override
    public String toString() {
        return String.format("Student [ID: %d, Name: %s, Year: %d]", studentID, name, yearOfStudy);
    }




}
