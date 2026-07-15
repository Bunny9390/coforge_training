package com.coforge.com.coforge.main;

import com.coforge.com.coforge.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student1 = context.getBean("student", Student.class);
        student1.displayStudentDetails();
    }
}


// output
// ========== Student Details ==========

// Student Id      : 101
// Student Name    : Rahul Sharma
// Address : City-1, State-1

// Subjects Enrolled
// -------------------------
// Java
// Spring Core
// Hibernate
// MySQL
// React

// Marks
// -------------------------
// Java : 95
// Spring : 90
// Hibernate : 88
// MySQL : 92
// React : 85