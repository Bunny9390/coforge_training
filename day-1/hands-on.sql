/*Assignment 1*/
create database school
use school
create table students(st_id int primary key,name varchar(50),age int,gender varchar(10),city varchar(50));

/*Assignment 2*/
INSERT INTO Students
(St_id, Name, Age, Gender, City)
VALUES
(101, 'Rahul', 20, 'Male', 'Hyderabad'),
(102, 'Priya', 19, 'Female', 'Chennai'),
(103, 'Arjun', 21, 'Male', 'Bengaluru'),
(104, 'Sneha', 20, 'Female', 'Mumbai'),
(105, 'Kiran', 22, 'Male', 'Pune');

/*Assignment 3*/
select * from students
select name,city from students
select * from students where age>20
select * from students where gender = 'Female'
select * from students where city='hyderabad'

/*Assignment 4*/
select * from students order by name asc
select * from students order by age desc
select * from students order by city asc,name asc

/*Assignment 5*/
select * from students where age between 19 and 22
select * from students where name like 'R%'
select * from students where name like '%i'
select * from students where age in (20,22)

/*Assignment 6*/
SET SQL_SAFE_UPDATES = 0;
update students set city='delhi'where name='Rahul'
update students set age = age+1 where name='Arjun'
update students set city='Kolkata' where name = 'Sneha'

/*Assignment 7*/
delete from students where st_id = 105
delete from students where city='Chennai'