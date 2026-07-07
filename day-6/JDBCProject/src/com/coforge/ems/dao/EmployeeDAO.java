package com.coforge.ems.dao;

import com.coforge.ems.model.Employee;
import com.coforge.ems.util.ApplicationProperties;
import com.coforge.ems.util.DBUtil;
import com.coforge.ems.util.EMSConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// This class performs all CRUD operations for employees using JDBC.
public class EmployeeDAO {
    public boolean addEmployee(Employee emp) throws SQLException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EMSConstants.INSERT_QUERY)) {
            preparedStatement.setInt(1, emp.getEmpId());
            preparedStatement.setString(2, emp.getEmpName());
            preparedStatement.setDouble(3, emp.getEmpSalary());
            preparedStatement.setString(4, emp.getEmpDepartment());
            preparedStatement.setString(5, emp.getEmpEmail());

            int rows = preparedStatement.executeUpdate();
            return rows > 0;
        }
    }

    public List<Employee> viewEmployees() throws SQLException {
        List<Employee> employeeList = new ArrayList<Employee>();

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EMSConstants.SELECT_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setEmpId(resultSet.getInt(ApplicationProperties.COLUMN_EMP_ID));
                employee.setEmpName(resultSet.getString(ApplicationProperties.COLUMN_EMP_NAME));
                employee.setEmpSalary(resultSet.getDouble(ApplicationProperties.COLUMN_EMP_SALARY));
                employee.setEmpDepartment(resultSet.getString(ApplicationProperties.COLUMN_EMP_DEPARTMENT));
                employee.setEmpEmail(resultSet.getString(ApplicationProperties.COLUMN_EMP_EMAIL));
                employeeList.add(employee);
            }
        }

        return employeeList;
    }

    public Employee searchEmployee(int id) throws SQLException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EMSConstants.SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Employee employee = new Employee();
                    employee.setEmpId(resultSet.getInt(ApplicationProperties.COLUMN_EMP_ID));
                    employee.setEmpName(resultSet.getString(ApplicationProperties.COLUMN_EMP_NAME));
                    employee.setEmpSalary(resultSet.getDouble(ApplicationProperties.COLUMN_EMP_SALARY));
                    employee.setEmpDepartment(resultSet.getString(ApplicationProperties.COLUMN_EMP_DEPARTMENT));
                    employee.setEmpEmail(resultSet.getString(ApplicationProperties.COLUMN_EMP_EMAIL));
                    return employee;
                }
            }
        }

        return null;
    }

    public boolean updateEmployee(Employee emp) throws SQLException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EMSConstants.UPDATE_QUERY)) {
            preparedStatement.setString(1, emp.getEmpName());
            preparedStatement.setDouble(2, emp.getEmpSalary());
            preparedStatement.setString(3, emp.getEmpDepartment());
            preparedStatement.setString(4, emp.getEmpEmail());
            preparedStatement.setInt(5, emp.getEmpId());

            int rows = preparedStatement.executeUpdate();
            return rows > 0;
        }
    }

    public boolean deleteEmployee(int id) throws SQLException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EMSConstants.DELETE_QUERY)) {
            preparedStatement.setInt(1, id);

            int rows = preparedStatement.executeUpdate();
            return rows > 0;
        }
    }
}
