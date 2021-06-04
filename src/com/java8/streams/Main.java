package com.java8.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Main {
	static Supplier<List<Student>> s1 = StudentDataBase::getAllStudents;
	static Function<Student,String> fgetname = Student::getName;
	static Function<Student,List<String>> fgetActivities = Student::getActivities;
	static Consumer<Student> fgetnameandgpa = student -> System.out.println("Student Name - "+student.getName()+" ------- "+ student.getGpa());
	public static void main(String[] args) {
		
		//getStudenList().forEach(System.out::println);
		//getALLActivities().forEach(System.out::println);
		//().forEach(System.out::println);
		//System.out.println(getDistinctActivitiesCount());
		//getsortedByGrade().forEach(fgetnameandgpa);
		//getFemaleStudent().forEach(System.out::println);
		System.out.println(getHighestGradeStudent().getName());
	}
	
	// Map is used to transform the value form one type to other
	private static Set<String> getStudenList(){
		
		Set<String> names = s1.get().stream()
								.map(fgetname)
								.map(String::toUpperCase)
								.collect(Collectors.toSet());
		return names;
		
		
		
	}
	// flatMap is used to transform the value into list of elements
private static Set<String> getALLActivities(){
		
		Set<String> names = s1.get().stream()
								.map(fgetActivities)
								.flatMap(List::stream)
								.collect(Collectors.toSet());
		return names;
		
		
		
	}
//default sorting
private static List<String> getDistinctActivities(){
	
	List<String> activities = s1.get().stream().map(fgetActivities).flatMap(List::stream).distinct().sorted().collect(Collectors.toList());
					
	return activities;
	
	
}
//customized sorting using comarator
private static long getDistinctActivitiesCount(){
	
	long number= s1.get().stream().map(fgetActivities).flatMap(List::stream).distinct().count();
					
	return number;
	
	
}
//reversing the sorting result
private static List<Student> getsortedByGrade(){
	
	List<Student> result = s1.get().stream()
							.sorted(Comparator.comparing(Student::getGpa).reversed())
							.collect(Collectors.toList());
	return result;
					
	
	
}
//filter used to filter the records
private static List<Student> getFemaleStudent(){
	
	List<Student> result = s1.get().stream()
							.filter(student -> student.getGender().equals("female"))
							.collect(Collectors.toList());
	return result;
					
	
	
}
//Tis is a terminal operation used to reduce the content of a stream to a single value
public static Student getHighestGradeStudent(){

    Optional<Student> studentOptional =  s1.get().stream()
            .reduce((s1,s2)->(s1.getGpa()>s2.getGpa()) ? s1 : s2);
    if(studentOptional.isPresent()) {
    	
    	return studentOptional.get();
    }else {
    	System.out.println("Student not present");
    	return null;
    }
	
    
}


	

}
