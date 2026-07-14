package com.coforge.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.coforge.model.Course;
import com.coforge.model.Student;

public class Main {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("Hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Student s1 = new Student("John");
        Student s2 = new Student("Priya");

        Course c1 = new Course("Java");
        Course c2 = new Course("Hibernate");
        Course c3 = new Course("Spring Boot");

        s1.getCourses().add(c1);
        s1.getCourses().add(c3);

        s2.getCourses().add(c1);
        s2.getCourses().add(c2);

        session.save(c1);
        session.save(c2);
        session.save(c3);

        session.save(s1);
        session.save(s2);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("Data Inserted Successfully...");
    }
}