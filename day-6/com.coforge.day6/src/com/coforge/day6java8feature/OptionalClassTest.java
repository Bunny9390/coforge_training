package com.coforge.day6java8feature;

import java.util.Optional;

class Employee {
	private int ename;

	public int getEname() {
		return ename;
	}

	public void setEname(int ename) {
		this.ename = ename;
	}
	
}

public class OptionalClassTest {
	public static Optional<Employee> getEmployee() {
		Employee emp = null;
		Optional<Employee> optionalEmployee = Optional.ofNullable(emp);
		return optionalEmployee;
	}
	public static void main(String[] args) {
		Optional<Employee> optional = OptionalEmployee.get();
		
		if(OptionalEmployee.isPresent() ) {
		System.out.println(emp.getEname());
		}else {
			System.out.println("Employee not found");
	}
	}

}
