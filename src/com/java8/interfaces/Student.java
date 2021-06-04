package com.java8.interfaces;

import java.util.Comparator;

public class Student {

	private String stuName;
	private Integer stuRollNo;
	private Integer totalMarks;
	public Student(String stuName, Integer stuRollNo, Integer totalMarks) {
		super();
		this.stuName = stuName;
		this.stuRollNo = stuRollNo;
		this.totalMarks = totalMarks;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getStuRollNo() {
		return stuRollNo;
	}
	public void setStuRollNo(Integer stuRollNo) {
		this.stuRollNo = stuRollNo;
	}
	public Integer getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}
	/*@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return o.getTotalMarks().compareTo(this.getTotalMarks());
		//return this.getTotalMarks().compareTo(o.getTotalMarks());
	}*/
	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuRollNo=" + stuRollNo + ", totalMarks=" + totalMarks + "]";
	}

	
	
}
