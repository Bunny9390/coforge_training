package com.coforge.ems.model;

import com.coforge.ems.util.ApplicationProperties;

// This class represents one employee record in the system.
public class Employee {
    private int empId;
    private String empName;
    private double empSalary;
    private String empDepartment;
    private String empEmail;

    public Employee() {
    }

    public Employee(int empId, String empName, double empSalary, String empDepartment, String empEmail) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empDepartment = empDepartment;
        this.empEmail = empEmail;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    @Override
    public String toString() {
        return String.format(
                ApplicationProperties.EMPLOYEE_TO_STRING_FORMAT,
                empId,
                empName,
                empSalary,
                empDepartment,
                empEmail
        );
    }
}
