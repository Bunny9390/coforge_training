use mydatabase;
create database mydatabase
create table tbl_employee( eid int, ename varchar(50),esalary int,dno int)
insert into tbl_employee values (101,'raju',25000,10),(102,'ramu',35000,11),(103,'shreya',45000,12),(104,'bheem',50000,13)
select * from tbl_employee
select dno,count(*) from tbl_employee group by dno

UPDATE tbl_employee
SET dno = 10
WHERE eid IN (101, 103);

UPDATE tbl_employee
SET dno = 20
WHERE eid IN (102, 104);

 select * from tbl_employee
 
 select dno,sum(esalary),avg(esalary),min(esalary),max(esalary) from tbl_employee 
 group by dno
 
  select dno,sum(esalary),avg(esalary),min(esalary),max(esalary) from tbl_employee 
  group by dno 
  having min(esalary)>15000
 
  select dno,sum(esalary),avg(esalary),min(esalary),max(esalary) from tbl_employee
  group by dno 
  order by dno DEsC
  
  select * from tbl_employee order by eid desc
   
create table tbl_dept(dpno int,dpname varchar(50))
insert into tbl_dept values(10,'development'),(20,'Testing')
select * from tbl_dept

select dpname from tbl_dept where dpno = (select dpno from tbl_employee where eid=101)

 
 select * from tbl_employee
 where dno = (select dpno from tbl_dept where dpname='Testing')
 
 select dpname from tbl_dept where dpno = 
 (select dno from tbl_employee where ename='raju') 
 
 select dpname from tbl_dept where dpno in 
 (select dno from tbl_employee where eid = 101 or eid = 102)
 
 drop table tbl_employee
 
 create table tbl_employee( eid int primary key, ename varchar(50) not null
 ,esalary int check(esalary>0),email varchar(20) unique,dno int);
 
 /*constraint voilated*/
 insert into tbl_employee values (101,'ramu',-10000,'abc@gmail.com',10) 
 
 desc tbl_employee
 
 drop table tbl_employee
 drop table tbl_dept
 
 create table tbbl_dept(
 dno int primary key,dname varchar(20))
 desc tbbl_dept
 create table tbl_employee( 
 eid int primary key, ename varchar(50),esalary int,
 dno int references tbl_dept(dno))
 
 insert into tbl_employee values
 (101,'ramesh',20000,10)

select * from tbl_employee

DELIMITER //

CREATE PROCEDURE insertEmployee(
    IN eid INT,
    IN ename VARCHAR(20),
    IN esalary INT,
    IN dno INT
)
BEGIN
    INSERT INTO tbl_employee(eid, ename, esalary, dno)
    VALUES (eid, ename, esalary, dno);
END //
DELIMITER ;
drop procedure insertEmployee
CALL insertEmployee(107, 'Bunny', 3000, 10);
SELECT DATABASE();
USE mydatabase;

CREATE TABLE tbl_employee (
    eid INT PRIMARY KEY,
    ename VARCHAR(50),
    esalary INT,
    dno INT
);


SHOW TABLES;

CALL insertEmployee(107, 'Bunny', 3000, 10);
SELECT * FROM tbl_employee;

DELIMITER //
CREATE PROCEDURE getEmployeeName(
    IN empid INT,
    OUT empname VARCHAR(20)
)
BEGIN
    SELECT ename
    INTO empname
    FROM tbl_employee
    WHERE eid = empid;
END //
DELIMITER ;

call getEmployeeName(107,@empname)
select @empname

DELIMITER //
CREATE FUNCTION getEmpName(empid INT)
RETURNS VARCHAR(20) deterministic
BEGIN
    DECLARE empname VARCHAR(20);
    SELECT ename
    INTO empname
    FROM tbl_employee
    WHERE eid = empid;
    RETURN empname;
END //
DELIMITER ;

select getEmpName(107)



/* Joints */
CREATE TABLE Employee (
    eid INT PRIMARY KEY,
    ename VARCHAR(20),
    salary INT,
    dept_id INT
);
INSERT INTO Employee VALUES
(101,'Raju',25000,1),
(102,'Ramu',30000,2),
(103,'Bunny',35000,1),
(104,'Shreya',40000,3),
(105,'Bheem',45000,NULL);

CREATE TABLE Department (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(20)
);
INSERT INTO Department VALUES
(1,'Development'),
(2,'Testing'),
(3,'HR'),
(4,'Marketing');

/*inner join*/
SELECT e.eid,e.ename,d.dept_name
FROM Employee e
INNER JOIN Department d
ON e.dept_id = d.dept_id;

/*left join*/
SELECT e.eid,e.ename,d.dept_name
FROM Employee e
LEFT JOIN Department d
ON e.dept_id = d.dept_id;

/*right join*/
SELECT e.eid,e.ename,d.dept_name
FROM Employee e
RIGHT JOIN Department d
ON e.dept_id = d.dept_id;

/*natural join*/
SELECT *
FROM Employee
NATURAL JOIN Department;

/*cross join*/
SELECT ename,dept_name
FROM Employee
CROSS JOIN Department;

/*self join*/
CREATE TABLE Employee1(
    eid INT PRIMARY KEY,
    ename VARCHAR(20),
    manager_id INT
);
INSERT INTO Employee1 VALUES
(101,'Raju',NULL),
(102,'Ramu',101),
(103,'Bunny',101),
(104,'Shreya',102);
SELECT e.ename AS Employee,
       m.ename AS Manager
FROM Employee1 e
LEFT JOIN Employee1 m
ON e.manager_id = m.eid;

 /*equi join*/
 SELECT *
FROM Employee e, Department d
WHERE e.dept_id = d.dept_id;

/*full outer join */
SELECT e.eid,
       e.ename,
       d.dept_name
FROM Employee e
LEFT JOIN Department d
ON e.dept_id = d.dept_id
UNION
SELECT e.eid,
       e.ename,
       d.dept_name
FROM Employee e
RIGHT JOIN Department d
ON e.dept_id = d.dept_id;








 
 
 