package com.coforge.day5.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class JDBCInsert {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step-2 : connecting with DB
		Connection connection = DriverManager.getConnection(
			    "jdbc:mysql://localhost:3306/EmployeeDB",
			    "root",
			    "MySQL@123"
			);		
		//step-3 : Creating statement
		String sql = "insert into Employee values(?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//step-4 : Executing
		statement.setInt(1, 107);
		statement.setString(2, "Anirudh");
		statement.setString(3,"It");
		statement.setInt(4,45000);
		statement.setString(5,"Hyderabad");
		
		int n = statement.executeUpdate(); //insert,update and delete
		if (n == 1) {
			System.out.println("Employee details saved");
		}else {
			System.out.println("Employee details not saved");
		}
		
		
		
		//step-5 : closing
		statement.close();
		connection.close();

	}

}
