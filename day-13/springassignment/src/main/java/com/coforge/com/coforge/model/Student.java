package com.coforge.com.coforge.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    private int studentId;
    private String studentName;
    private Address address;
    private List<String> subjects;
    private Set<String> skills;
    private Map<String, Integer> marks;

    public Student() {
        super();
    }

    public Student(int studentId, String studentName, Address address, List<String> subjects, Set<String> skills, Map<String, Integer> marks) {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.subjects = subjects;
        this.skills = skills;
        this.marks = marks;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    public void displayStudentDetails() {
        System.out.println("========== Student Details ==========");
        System.out.println();
        System.out.println("Student Id      : " + studentId);
        System.out.println("Student Name    : " + studentName);
        if (address != null) {
            address.displayAddressDetails();
        }
        System.out.println();
        System.out.println("Subjects Enrolled");
        System.out.println("-------------------------");
        for (String s : subjects) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println("Marks");
        System.out.println("-------------------------");
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId + "]";
    }
}
