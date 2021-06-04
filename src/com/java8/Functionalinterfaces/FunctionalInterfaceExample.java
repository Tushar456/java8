package com.java8.Functionalinterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {
	//Method Reference
	static Predicate<Student> p1 = FunctionalInterfaceExample::prdicateMethodReference;
	static Supplier<List<Student>> s1 = StudentDataBase::getAllStudents;
	static Consumer<Student> c0 = student -> System.out.print(student.getGradeLevel());
    static Consumer<Student> c1 = student -> System.out.println("-----"+student.getName());
    static Consumer<Student> c2 = student -> System.out.println(student.getActivities());
    static Consumer<Student> c3 = FunctionalInterfaceExample::methodReferenceConsumer;



	
    
    static Function<List<Student>, Map<String, Double>> fu = FunctionalInterfaceExample::methodReferencefunction;

	
    
	public static void main(String[] args) {
		
		//printStudentName();
		//printStudentNameAndActivites();
		printGradeTopper();
		//printNameandGPA();
	}
	
	
	public static void printStudentName() {
		
		s1.get().forEach(c1);
		
	}
	
	public static void printStudentNameAndActivites() {
		
		s1.get().forEach(c1.andThen(c2));
		
	}
	
public static void printGradeTopper() {
		
        s1.get().forEach(c3);		
			

}

public static void printNameandGPA() {
	
    System.out.println(fu.apply(s1.get()));
		

}
static boolean prdicateMethodReference(Student student) {
	
	return student.getGradeLevel() >= 2  && student.getGpa() >=3.5;
}

private static Map<String, Double> methodReferencefunction(List<Student> students) {
		Map<String,Double> studenMap = new HashMap();
		students.forEach(studdent -> {
			studenMap.put(studdent.getName(), studdent.getGpa());
		});
		
		return studenMap;
		
	}
private static void methodReferenceConsumer(Student student) {
	if(p1.test(student)) {
		
		c0.andThen(c1).accept(student);
	}
}

}
