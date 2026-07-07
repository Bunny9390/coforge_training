package com.coforge.ems.util;

// This class stores all shared constants used across the project.
public class ApplicationProperties {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/employee";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "MySQL@123";
    public static final String DATABASE_BASE_URL = "jdbc:mysql://localhost:3306/";

    public static final String INSERT_EMPLOYEE = "INSERT INTO employee(empId, empName, empSalary, empDepartment, empEmail) VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_EMPLOYEE = "UPDATE employee SET empName = ?, empSalary = ?, empDepartment = ?, empEmail = ? WHERE empId = ?";
    public static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE empId = ?";
    public static final String FIND_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE empId = ?";
    public static final String FIND_ALL_EMPLOYEES = "SELECT * FROM employee";
    public static final String CREATE_DATABASE_SQL = "CREATE DATABASE IF NOT EXISTS employee";
    public static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS employee(empId INT PRIMARY KEY, empName VARCHAR(50), empSalary DOUBLE, empDepartment VARCHAR(50), empEmail VARCHAR(50))";

    public static final String DATABASE_CONNECTED_SUCCESSFULLY = "Database connected successfully.";
    public static final String EMPLOYEE_ADDED_SUCCESSFULLY = "Employee added successfully.";
    public static final String EMPLOYEE_UPDATED_SUCCESSFULLY = "Employee updated successfully.";
    public static final String EMPLOYEE_DELETED_SUCCESSFULLY = "Employee deleted successfully.";
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found.";
    public static final String INVALID_EMPLOYEE_DETAILS = "Invalid employee details.";
    public static final String DATABASE_CONNECTION_FAILED = "Database connection failed.";
    public static final String INVALID_CHOICE = "Invalid choice.";
    public static final String INVALID_CHOICE_TRY_AGAIN = "Invalid choice. Please try again.";
    public static final String EXIT_MESSAGE = "Thank you for using Employee Management System.";
    public static final String MENU_TEXT = "=====================================\nEmployee Management System\n1. Add Employee\n2. View All Employees\n3. Search Employee\n4. Update Employee\n5. Delete Employee\n6. Exit\nEnter your choice:\n=====================================";

    public static final String NAME_CANNOT_BE_EMPTY = "Name cannot be empty.";
    public static final String SALARY_MUST_BE_GREATER_THAN_ZERO = "Salary must be greater than zero.";
    public static final String DEPARTMENT_CANNOT_BE_EMPTY = "Department cannot be empty.";
    public static final String INVALID_EMAIL_FORMAT = "Invalid email format.";
    public static final String EMPLOYEE_ID_MUST_BE_POSITIVE = "Employee ID must be positive.";
    public static final String EMPLOYEE_OBJECT_CANNOT_BE_NULL = "Employee object cannot be null.";

    public static final String NO_EMPLOYEES_FOUND = "No employees found.";
    public static final String PLEASE_ENTER_VALID_NUMBER = "Please enter a valid number.";
    public static final String DATABASE_ERROR_PREFIX = "Database error: ";
    public static final String FAILED_TO_ADD_EMPLOYEE = "Failed to add employee.";
    public static final String FAILED_TO_UPDATE_EMPLOYEE = "Failed to update employee.";
    public static final String ENTER_EMPLOYEE_ID = "Enter Employee ID: ";
    public static final String ENTER_EMPLOYEE_NAME = "Enter Employee Name: ";
    public static final String ENTER_EMPLOYEE_SALARY = "Enter Employee Salary: ";
    public static final String ENTER_EMPLOYEE_DEPARTMENT = "Enter Employee Department: ";
    public static final String ENTER_EMPLOYEE_EMAIL = "Enter Employee Email: ";
    public static final String ENTER_NEW_EMPLOYEE_NAME = "Enter New Employee Name: ";
    public static final String ENTER_NEW_EMPLOYEE_SALARY = "Enter New Employee Salary: ";
    public static final String ENTER_NEW_EMPLOYEE_DEPARTMENT = "Enter New Employee Department: ";
    public static final String ENTER_NEW_EMPLOYEE_EMAIL = "Enter New Employee Email: ";
    public static final String ENTER_EMPLOYEE_ID_TO_SEARCH = "Enter Employee ID to search: ";
    public static final String ENTER_EMPLOYEE_ID_TO_UPDATE = "Enter Employee ID to update: ";
    public static final String ENTER_EMPLOYEE_ID_TO_DELETE = "Enter Employee ID to delete: ";
    public static final String MENU_PROMPT = "Enter your choice: ";
    public static final String EMAIL_SEPARATOR = "@";
    public static final String EMPLOYEE_TO_STRING_FORMAT = "Employee{empId=%d, empName='%s', empSalary=%.2f, empDepartment='%s', empEmail='%s'}";
    public static final String COLUMN_EMP_ID = "empId";
    public static final String COLUMN_EMP_NAME = "empName";
    public static final String COLUMN_EMP_SALARY = "empSalary";
    public static final String COLUMN_EMP_DEPARTMENT = "empDepartment";
    public static final String COLUMN_EMP_EMAIL = "empEmail";

    public static final int MENU_OPTION_ADD = 1;
    public static final int MENU_OPTION_VIEW = 2;
    public static final int MENU_OPTION_SEARCH = 3;
    public static final int MENU_OPTION_UPDATE = 4;
    public static final int MENU_OPTION_DELETE = 5;
    public static final int MENU_OPTION_EXIT = 6;

    private ApplicationProperties() {
    }
}
