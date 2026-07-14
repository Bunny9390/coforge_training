package com.coforge.model;
import javax.persistence.Entity;
import javax.persistence.Table; 
import javax.persistence.Column;
import javax.persistence.Id;


@Entity
@Table(name = "Employee")

public class Employee {

    @Id
    @Column(name = "empId",length = 5)
    private int empId;

    @Column(name = "empName",length = 20)
    private String empName;

    @Column(name = "empSalary")
    private double empSalary;

    @Column(name = "empDepartment",length = 20)
    private String empDepartment;

    @Column(name = "empEmail",length = 30)
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
        return "Employee [empId=" + empId +
                ", empName=" + empName +
                ", empSalary=" + empSalary +
                ", empDepartment=" + empDepartment +
                ", empEmail=" + empEmail + "]";
    }
}