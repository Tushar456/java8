package com.java8.interfaces;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface MyInterface {
	
	// we can overide default method of interface
	default public List<Student> sortedStudent(List<Student> student){
		
		Collections.sort(student, new NameComarator());
		
		return student;
		
		
	}
	//static method of interface cannot be overridden by the implementing class and it can only using the the instace of Inferface
	public static void message() {
		System.out.println("interface static method");
	}
	
	public Student topper(List<Student> student);

}
