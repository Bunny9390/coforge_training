package com.coforge.main;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.coforge.model.Employee;

public class MainClass {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


         // Replace with actual employee ID
        Employee employee = new Employee(1, "Rishika", 50000.0, "IT", "rishika@gmail.com");
        
        //session.get(Employee.class, 1);
        //System.out.println("Employee Details: " + employee.getEmpId() + ", " + employee.getEmpName() + ", " + employee.getEmpSalary() + ", " + employee.getEmpDepartment() + ", " + employee.getEmpEmail());
        
        session.delete(employee);
        transaction.commit();
        sessionFactory.close();
        

        //session.save(employee);
        //transaction.commit();
        session.close();
        System.out.println("Employee deleted successfully!");
    }
}