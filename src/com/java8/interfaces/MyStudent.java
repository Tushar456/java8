package com.java8.interfaces;

import java.util.Collections;
import java.util.List;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public class MyStudent implements MyInterface {
	
	
	// we can overide default method of interface
	@Override
	public List<Student> sortedStudent(List<Student> student) {
		Collections.sort(student, new MarksComparator());
		return student;
	}

	@Override
	public Student topper(List<Student> student) {
		
		Collections.sort(student,new MarksComparator());
		Student topper = student.get(0);
		return topper;
	}

	
   
}
