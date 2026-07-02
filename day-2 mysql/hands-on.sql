CREATE DATABASE EmployeeManagement;
USE EmployeeManagement;
CREATE TABLE Department
(
    DeptID INT PRIMARY KEY,
    DeptName VARCHAR(50),
    Location VARCHAR(50)
);

CREATE TABLE Employee
(
    EmpID INT PRIMARY KEY,
    EmpName VARCHAR(50),
    Gender VARCHAR(10),
    Age INT,
    Salary DECIMAL(10,2),
    Designation VARCHAR(50),
    DeptID INT,
    HireDate DATE,
    FOREIGN KEY (DeptID)
    REFERENCES Department(DeptID)
);

CREATE TABLE Attendance
(
    AttendanceID INT PRIMARY KEY,
    EmpID INT,
    AttendanceDate DATE,
    Status VARCHAR(10),
    FOREIGN KEY(EmpID)
    REFERENCES Employee(EmpID)
);

INSERT INTO Department VALUES
(101,'HR','Hyderabad'),
(102,'Finance','Mumbai'),
(103,'IT','Bangalore'),
(104,'Sales','Chennai');

INSERT INTO Employee VALUES
(1,'Amit','Male',28,45000,'Software Engineer',103,'2022-05-10'),
(2,'Priya','Female',30,55000,'HR Manager',101,'2021-03-15'),
(3,'Rahul','Male',27,50000,'Accountant',102,'2023-01-20'),
(4,'Sneha','Female',25,42000,'Sales Executive',104,'2022-09-12'),
(5,'Kiran','Male',31,60000,'Team Lead',103,'2020-11-18');

INSERT INTO Attendance VALUES
(1,1,'2026-07-01','Present'),
(2,2,'2026-07-01','Present'),
(3,3,'2026-07-01','Absent'),
(4,4,'2026-07-01','Present'),
(5,5,'2026-07-01','Present');

/*Basic Queries*/
SELECT * FROM Employee;
SELECT EmpName, Salary FROM Employee;
SELECT * FROM Employee WHERE Salary > 50000;
SELECT * FROM Employee WHERE Age > 30;

/*Where Clause*/
SELECT *
FROM Employee
WHERE DeptID =
(
SELECT DeptID
FROM Department
WHERE DeptName='IT'
);
select * from Employee where Gender = 'Female'
select * from Employee where HireDate>'2022-01-01'

/*Orderby*/
select * from Employee order by Salary DESC
select * from Employee order by EmpName ASC


/*Aggregate Functions*/
select count(*) from Employee
select max(Salary) from Employee
select min(Salary) from Employee
select avg(Salary) from Employee
select sum(Salary) as totalSalary from Employee

/*GROUP BY*/
select DeptID,count(*) as totalemp from Employee group by DeptID; 
select DeptID,avg(Salary) as avgemp from Employee group by DeptID;
select DeptID,max(Salary) as highsalemp from Employee group by DeptID;


/*Having*/
SELECT DeptID,COUNT(*) AS TotalEmployees FROM Employee GROUP BY DeptID HAVING COUNT(*)>1;
SELECT DeptID,AVG(Salary) AS AvgSalary FROM Employee GROUP BY DeptID HAVING AVG(Salary)>50000;


/*Join Queries*/
SELECT e.EmpName, d.DeptName FROM Employee e JOIN Department d ON e.DeptID=d.DeptID;
SELECT e.EmpName, d.DeptName, d.Location FROM Employee e JOIN Department d ON e.DeptID=d.DeptID;
SELECT e.EmpName, a.AttendanceDate, a.Status FROM Employee e JOIN Attendance a ON e.EmpID=a.EmpID;

/*Update*/
UPDATE Employee SET Salary=Salary*1.10 WHERE DeptID=103;
UPDATE Employee SET Designation='Senior Software Engineer' WHERE EmpID=1;
UPDATE Employee SET DeptID=102 WHERE EmpID=4;

/*delete*/
DELETE FROM Employee WHERE Salary<40000;
DELETE FROM Attendance WHERE AttendanceDate='2026-07-01';

/*Views*/
CREATE VIEW EmployeeDetails AS
SELECT e.EmpID,e.EmpName,d.DeptName,e.Salary FROM Employee e JOIN Department d ON e.DeptID=d.DeptID;

SELECT * FROM EmployeeDetails;


/*Stored Procedure*/
DELIMITER //
CREATE PROCEDURE GetEmployees()
BEGIN
SELECT * FROM Employee;
END //
DELIMITER ;

CALL GetEmployees();