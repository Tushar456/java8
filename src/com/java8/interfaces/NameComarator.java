package com.java8.interfaces;

import java.util.Comparator;

public class NameComarator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		
		return o2.getStuName().compareTo(o1.getStuName());
	}

}
