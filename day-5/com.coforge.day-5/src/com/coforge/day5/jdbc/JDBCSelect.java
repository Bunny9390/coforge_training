package com.coforge.day5.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCSelect {

    public static void main(String[] args) throws Exception {

        // Step 1: Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Connect to Database
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EmployeeDB",
                "root",
                "MySQL@123");

        // Step 3: Create PreparedStatement
        String sql = "select * from Employee";
        PreparedStatement statement = connection.prepareStatement(sql);
        

        // Step 4: Set Values
        ResultSet resultset = statement.executeQuery();
        while (resultset.next()) {
        	System.out.println(
                    resultset.getInt("EmpID") + " " +
                    resultset.getString("EmpName") + " " +
                    resultset.getString("Department") + " " +
                    resultset.getInt("Salary") + " " +
                    resultset.getString("City"));
        }
        
        

//        if (n == 1) {
//            System.out.println("Employee updated successfully");
//        } else {
//            System.out.println("Employee not found");
//        }

        // Step 5: Close Resources
        resultset.close();
        statement.close();
        connection.close();
    }
}