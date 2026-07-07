package com.coforge.ems.controller;

import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;
import com.coforge.ems.util.ApplicationProperties;

import java.sql.SQLException;
import java.util.List;

// This class acts as the controller between the UI and service layer.
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController() {
        employeeService = new EmployeeService();
    }

    public String addEmployee(Employee emp) {
        try {
            boolean success = employeeService.addEmployee(emp);
            if (success) {
                return ApplicationProperties.EMPLOYEE_ADDED_SUCCESSFULLY;
            }
            return ApplicationProperties.FAILED_TO_ADD_EMPLOYEE;
        } catch (InvalidEmployeeObjectException e) {
            return e.getMessage();
        } catch (SQLException e) {
            return ApplicationProperties.DATABASE_ERROR_PREFIX + e.getMessage();
        }
    }

    public List<Employee> viewEmployees() {
        try {
            return employeeService.viewEmployees();
        } catch (SQLException e) {
            System.out.println(ApplicationProperties.DATABASE_ERROR_PREFIX + e.getMessage());
            return null;
        }
    }

    public Employee searchEmployee(int id) {
        try {
            return employeeService.searchEmployee(id);
        } catch (SQLException e) {
            System.out.println(ApplicationProperties.DATABASE_ERROR_PREFIX + e.getMessage());
            return null;
        }
    }

    public String updateEmployee(Employee emp) {
        try {
            boolean success = employeeService.updateEmployee(emp);
            if (success) {
                return ApplicationProperties.EMPLOYEE_UPDATED_SUCCESSFULLY;
            }
            return ApplicationProperties.FAILED_TO_UPDATE_EMPLOYEE;
        } catch (InvalidEmployeeObjectException e) {
            return e.getMessage();
        } catch (SQLException e) {
            return ApplicationProperties.DATABASE_ERROR_PREFIX + e.getMessage();
        }
    }

    public String deleteEmployee(int id) {
        try {
            boolean success = employeeService.deleteEmployee(id);
            if (success) {
                return ApplicationProperties.EMPLOYEE_DELETED_SUCCESSFULLY;
            }
            return ApplicationProperties.EMPLOYEE_NOT_FOUND;
        } catch (SQLException e) {
            return ApplicationProperties.DATABASE_ERROR_PREFIX + e.getMessage();
        }
    }
}
