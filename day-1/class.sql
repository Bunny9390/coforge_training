create database employee

use college

create table tbl_employee(
eid int,
ename varchar(50),
e_salary int
);

select * from tbl_employee

Insert into tbl_employee values (101,'bunny',50000);,(102,'anirudh',45000);

describe tbl_employee

Insert into tbl_employee values (103,null,50000)

select * from tbl_employee where eid!=101

select ename from tbl_employee where e_salary > 40000

select eid,e_salary from tbl_employee where ename is not null

select * from tbl_employee where eid in (101,103,105)

select * from tbl_employee where e_salary between 45000 and 50000

select * from tbl_employee where ename not like '%u%'

update tbl_employee set e_salary=0 where eid=101
select * from tbl_employee
rollback

delete from tbl_employee where ename = ''

select eid as "emp id" , 'Bunny' ,sysdate() as 'cur date', 100+200 from tbl_employee

alter table tbl_employee add column dsalary int

select * from tbl_emp
 
alter table tbl_employee drop column dno

alter table tbl_employee rename column eid to emp_id

truncate table tbl_employee

rename table tbl_employee to tbl_emp

drop table tbl_emp




