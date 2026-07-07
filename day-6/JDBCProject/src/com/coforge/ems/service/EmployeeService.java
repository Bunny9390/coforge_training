package com.coforge.ems.service;

import com.coforge.ems.dao.EmployeeDAO;
import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.util.ApplicationProperties;

import java.sql.SQLException;
import java.util.List;

// This class validates employee details before invoking the DAO.
public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
    }

    public boolean addEmployee(Employee emp) throws InvalidEmployeeObjectException, SQLException {
        validateEmployee(emp);
        return employeeDAO.addEmployee(emp);
    }

    public List<Employee> viewEmployees() throws SQLException {
        return employeeDAO.viewEmployees();
    }

    public Employee searchEmployee(int id) throws SQLException {
        return employeeDAO.searchEmployee(id);
    }

    public boolean updateEmployee(Employee emp) throws InvalidEmployeeObjectException, SQLException {
        validateEmployee(emp);
        return employeeDAO.updateEmployee(emp);
    }

    public boolean deleteEmployee(int id) throws SQLException {
        return employeeDAO.deleteEmployee(id);
    }

    private void validateEmployee(Employee emp) throws InvalidEmployeeObjectException {
        if (emp == null) {
            throw new InvalidEmployeeObjectException(ApplicationProperties.EMPLOYEE_OBJECT_CANNOT_BE_NULL);
        }

        if (emp.getEmpId() <= 0) {
            throw new InvalidEmployeeObjectException(ApplicationProperties.EMPLOYEE_ID_MUST_BE_POSITIVE);
        }

        if (emp.getEmpName() == null || emp.getEmpName().trim().isEmpty()) {
            throw new InvalidEmployeeObjectException(ApplicationProperties.NAME_CANNOT_BE_EMPTY);
        }

        if (emp.getEmpSalary() <= 0) {
            throw new InvalidEmployeeObjectException(ApplicationProperties.SALARY_MUST_BE_GREATER_THAN_ZERO);
        }

        if (emp.getEmpDepartment() == null || emp.getEmpDepartment().trim().isEmpty()) {
            throw new InvalidEmployeeObjectException(ApplicationProperties.DEPARTMENT_CANNOT_BE_EMPTY);
        }

        if (emp.getEmpEmail() == null || emp.getEmpEmail().trim().isEmpty() || !emp.getEmpEmail().contains(ApplicationProperties.EMAIL_SEPARATOR)) {
            throw new InvalidEmployeeObjectException(ApplicationProperties.INVALID_EMAIL_FORMAT);
        }
    }
}
