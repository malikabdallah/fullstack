package com.spring.angular.fullstack.model;

public class Student {
    
    private Grades grades;

    public Student(Grades grades) {
        this.grades = grades;
    }
    
    public Grades getGrades(){
        return grades;
    }
}
