package com.java8.streams;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
 

/* Terminal operation start the whole pipeline
 * collect(),forEach(),min(),max(),reduce()
 */

public class StreamTerminalOperation {
	static Supplier<List<Student>> s1 = StudentDataBase::getAllStudents;
	static Function<Student,String> fgetname = Student::getName;
	static Function<Student,List<String>> fgetActivities = Student::getActivities;
	static Consumer<Student> fgetnameandgpa = student -> System.out.println("Student Name - "+student.getName()+" ------- "+ student.getGpa());
	public static void main(String[] args) {
		
	/*	System.out.println(joining());
		System.out.println(joiningWithDelimiter());
		System.out.println(joiningWithDelimiterWithPrefix());
		System.out.println("Student above 3.9 --> "+counting());
	    mapping().forEach(System.out::println);
	    System.out.println("Best Student "+maxBy().get());
	    System.out.println("Worst Student "+minBy().get());
	    
	    System.out.println("Total no of Notebooks : " + sum());

        System.out.println("Average no of Notebooks : " + average());
        
        groupingByGender();
	    
	    System.out.println(getHighestGradeStudent().getName());*/
		twoLevelGrouping();
	    
	    
	}
	
	public static String joining(){

        return s1.get().stream()
        		.map(Student::getName)
        		.collect(Collectors.joining());
        		// appends all the strings to produce the output,
    }

    public static String joiningWithDelimiter(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
    }

    public static String joiningWithDelimiterWithPrefix(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-","[","]"));
    }
    
    public static Long counting(){

        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.9)
                .collect(Collectors.counting());
    }
    //collector applies a transformation function first and then collects the data in a collection( could be any type of collection)
    public static Set<String> mapping(){

        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(Student::getName,Collectors.toSet()));
    }
    //minBy()
    public static Optional<Student> minBy(){

        Optional<Student> studentOptional = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));

        return studentOptional;
    }
    //maxBy
    public static Optional<Student> maxBy(){

        Optional<Student> studentOptional = StudentDataBase.getAllStudents().stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

        return studentOptional;
    }

    public static double sum(){

        double totalNoOfNotebooks = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingDouble(Student::getGpa));

        return totalNoOfNotebooks;
    }

    public static double average(){

        double totalNoOfNotebooks = StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.averagingDouble(Student::getGpa));

        return totalNoOfNotebooks;
    }
    
    
    
  //This is a terminal operation used to reduce the content of a stream to a single value
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
    /*groupingBy() collector is equivalent to the groupBy() operation in SQL.
     * Used to group the elements based on a property. 
     * The output of the groupingBy() is going to be a Map<K,V> 
     */
    public static void groupingByGender(){

        Map<String,List<Student>> studentMap =  s1.get()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));

        List<Student> maleStudents = studentMap.get("male");
        List<Student> femaleStudents = studentMap.get("female");
        System.out.println("Male Student ----> ");
        maleStudents.forEach(System.out::println);
        System.out.println("female Student ----> ");
        femaleStudents.forEach(System.out::println);
    }
    
    public  static void twoLevelGrouping(){

        Map<Integer,  Map<String,List<Student>>> studentMap =  StudentDataBase.getAllStudents().stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student -> student.getGpa()>= 3.8 ?  "OUTSTANDING" : "AVERAGE")));

        Stream.of(studentMap).forEach(System.out::println);

    }

   
    
    public static void partitioningBy_3(){

        Predicate<Student> gpaPredicate = (student) -> student.getGpa()>=3.8;

        Map<Boolean,Map<String, List<String>>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(partitioningBy(gpaPredicate,toMap(Student::getName,Student::getActivities)));

        System.out.println("studentMap : " + studentMap);

    }
  
    ///https://github.com/dilipsundarraj1/java-8/blob/master/java-8/src/com/learnJava/streams_terminal/StreamsGroupingByExample.java

  
    
}
