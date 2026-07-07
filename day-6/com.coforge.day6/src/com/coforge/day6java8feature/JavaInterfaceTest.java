package com.coforge.day6java8feature;

interface MyInterface {
	public void MyMethod1();

	public default void Mymethod2() {
		System.out.println("default method");

	}

	public static void Mymethod3() {
		System.out.println("static method");

	}
}

public class JavaInterfaceTest implements MyInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MyMethod1() {
		// TODO Auto-generated method stub
		System.out.println("Abstract Method");
		
	}
	@Override
	public void Mymethod2() {
		System.out.println("default method");

	}
	@Override
	public void Mymethod3() {
		System.out.println("static method");

	}

}
