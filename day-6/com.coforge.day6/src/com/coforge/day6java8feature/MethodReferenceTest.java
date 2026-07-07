package com.coforge.day6java8feature;

@FunctionalInterface
interface MyRef {
	void showMessage();
}
public class MethodReferenceTest {
	void myInstanceMethod() {
		System.out.println("Example for instance method ref");
	}
	static void myStaticMethod() {
		System.out.println("Example for static method ref");
	}
	MethodReferenceTest() {
		System.out.println("Constructor");
	}
	public static void main(String[] args) {
		
		//instance method
		MethodReferenceTest obj = new MethodReferenceTest();
		MyRef ref = obj::myInstanceMethod;
		
		//static method
		ref = MethodReferenceTest :: myStaticMethod;
		ref.showMessage();
		
		//constructor
		ref =  MethodReferenceTest::new;
		ref.showMessage();
		
	}

}
