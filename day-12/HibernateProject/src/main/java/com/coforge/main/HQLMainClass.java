package com.coforge.main;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.coforge.model.Employee;

public class HQLMainClass {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Query query = session.createQuery("FROM Employee");
        // List<Employee> employees = query.list();
        // System.out.println(employees);

        //HQL Static select query
        // Query query = session.createQuery("FROM Employee WHERE empId = 2");
        // List<Employee> employees = query.list();
        // System.out.println(employees);
        

        //HQL Dynamic select query
        // Query query = session.createQuery("FROM Employee WHERE empId = :id" );
        // query.setParameter("id",2);
        // List<Employee> employees = query.list();
        // System.out.println(employees);

        //HQL specific column select query
        // Query query = session.createQuery("SELECT empName FROM Employee");
        // List<String> employeeNames = query.list();
        // System.out.println(employeeNames);

        //HQL update query
        // Query query = session.createQuery("UPDATE Employee SET empName = :name WHERE empId = :id");
        // query.setParameter("name", "John Doe");
        // query.setParameter("id", 100);
        // int n = query.executeUpdate();
        // if (n > 0) {
        //     System.out.println("Employee updated successfully!");
        // } else {
        //     System.out.println("No employee found with the given ID.");
        // }

        //HQL delete query
        Query query = session.createQuery("DELETE FROM Employee WHERE empId = :id");
        query.setParameter("id", 100);
        int n = query.executeUpdate();
        if (n > 0) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("No employee found with the given ID.");
        }

        //HQL update query
        // Query query = session.createQuery("UPDATE Employee SET empName = :name WHERE empId = :id");
        // query.setParameter("name", "John Doe");
        // query.setParameter("id", 100);
        // int n = query.executeUpdate();
        // if (n > 0) {
        //     System.out.println("Employee updated successfully!");
        // } else {
        //     System.out.println("No employee found with the given ID.");
        // }

        transaction.commit();
        session.close();
        sessionFactory.close();
        
    }
}