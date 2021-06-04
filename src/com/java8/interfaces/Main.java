package com.java8.interfaces;

import java.util.ArrayList;
import java.util.List;

public class Main{
    
	static List<Student> list = new ArrayList<>();
	
	public static void main(String[] args) {
		MyInterface myinterface = new MyStudent();
		Student s1 = new Student("Tushar", 1, 400);
		Student s2 = new Student("Bunty", 2, 410);
		Student s3 = new Student("Vishal", 3, 420);
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		List<Student> sortedlist = myinterface.sortedStudent(list);
		
		sortedlist.forEach(System.out::println);
		
		System.out.println("Topper of the class is: "+ myinterface.topper(list).getStuName());
		
		
        MyInterface.message();
	}

	

}
