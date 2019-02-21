package com.javarush.task.task29.task2909.human;

import java.util.LinkedList;
import java.util.List;

public class University {
    private List<Student> students;
    private String name;
    private int age;
    public University(String name, int age){
     this.name = name;
     this.age = age;
     students = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double grade) {
        for(Student student : students)
            if(student.getAverageGrade() == grade)return student;
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double averageGrade = 0.0d;
        Student studentres = null;
        for(Student student : students)
            if(student.getAverageGrade() > averageGrade){
                averageGrade = student.getAverageGrade();
                studentres = student;
            }
        return studentres;
    }

    public Student getStudentWithMinAverageGrade() {
        double averageGrade = Double.MAX_VALUE;
        Student studentres = null;
        for(Student student : students)
            if(student.getAverageGrade() < averageGrade){
                averageGrade = student.getAverageGrade();
                studentres = student;
            }
        return studentres;
    }
    public void expel(Student student){
        students.remove(student);
    }
}