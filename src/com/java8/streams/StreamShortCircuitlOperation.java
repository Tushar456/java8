package com.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class StreamShortCircuitlOperation {
	static Supplier<List<Student>> s1 = StudentDataBase::getAllStudents;
	static Function<Student,String> fgetname = Student::getName;
	static Function<Student,List<String>> fgetActivities = Student::getActivities;
	static Consumer<Student> fgetnameandgpa = student -> System.out.println("Student Name - "+student.getName()+" ------- "+ student.getGpa());
	public static void main(String[] args) {
		
		
		List<Integer> integers = Arrays.asList(6,7,8,9,10);

        Optional<Integer> limitResult = limit(integers);
        int result = limitResult.isPresent() ? limitResult.get() : 0;
        System.out.println("The limit result is : " + result);

        Optional<Integer> skipResult = skip(integers);
        int result1 = skipResult.isPresent() ? skipResult.get() : 0;
        System.out.println("The skip result is : " + result1);
        
        System.out.println("allMatch - " +allMatch());
        System.out.println("nonMatch - " +nonmatch());
        System.out.println("anyMatch - " +anyMatch());
        
        System.out.println("findfirst - " +findFirst());
        System.out.println("findAny - " +findAny());
	}
	


//limit the number of records to be processed in the stream
public static Optional<Integer> limit(List<Integer> integers){
    return  integers.stream()
            .limit(2)
            .reduce((a,b)-> a+b);

}
//skip the number of records to be processed in the stream
public static Optional<Integer> skip(List<Integer> integers){
    return  integers.stream()
            .skip(3)
            .reduce((a,b)-> a+b);
}

//returns true if any of the element matches the condition
public static boolean anyMatch(){

    boolean result = s1.get().stream().anyMatch(student -> student.getGpa() >= 3.9);

    return result;
}
//returns true if  all the elements matches the condition
public static boolean allMatch(){

    boolean result = s1.get().stream().allMatch(student -> student.getGpa() >= 3.9);

    return result;
}
//returns true if all of the elements doesnot matches the condition
public static boolean nonmatch(){

    boolean result = s1.get().stream().noneMatch(student -> student.getGpa() >= 3.9);

    return result;
}
//return first encountered element in the stream
public static Student findAny(){

    Optional<Student> firststudent = s1.get().stream()
            .filter(student -> student.getGpa()>=3.8)
            .findAny();
    if(firststudent.isPresent()) {
    	return firststudent.get();
    }
    else {
    	return null;
    }
}

//return first element in the stream
public static Student findFirst(){

    Optional<Student> firststudent = s1.get().stream()
            .filter(student -> student.getGpa()>=3.8)
            .findFirst();
    if(firststudent.isPresent()) {
    	return firststudent.get();
    }
    else {
    	return null;
    }
}
	

}
