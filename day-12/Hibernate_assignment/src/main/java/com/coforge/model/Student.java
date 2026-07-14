package com.coforge.model;

import java.util.HashSet;
import java.util.Set;

public class Student {

    private int studentId;
    private String studentName;
    private Set<Course> courses = new HashSet<Course>();

    public Student() {
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}