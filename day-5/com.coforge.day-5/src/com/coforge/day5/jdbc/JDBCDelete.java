package com.coforge.day5.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCDelete {

    public static void main(String[] args) throws Exception {

        // Step 1: Load Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: Connect to Database
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/EmployeeDB",
                "root",
                "MySQL@123");

        // Step 3: Create PreparedStatement
        String sql = "UPDATE Employee SET Salary = ? WHERE EmpID = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        // Step 4: Set Values
        statement.setInt(1, 55000);   // New Salary
        statement.setInt(2, 107);     // Employee ID

        int n = statement.executeUpdate();

        if (n == 1) {
            System.out.println("Employee updated successfully");
        } else {
            System.out.println("Employee not found");
        }

        // Step 5: Close Resources
        statement.close();
        connection.close();
    }
}