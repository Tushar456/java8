package com.java8.Functionalinterfaces;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class INterfaceFunction {

	public static void main(String[] args) {
		
		// the Consumer interface take one arguement and returns void.
		Consumer<String> cons = x -> System.out.println("Numeber of character of Name - "+x +" is "+x.length());
		cons.accept("Tushar");
		
		// the BiConsumer interface take two argument as input and returns void.
				BiConsumer<String,String> biconsumer = (x,y) -> System.out.println("Name of person is -"+x.concat("-").concat(y));
				biconsumer.accept("Tushar","chaurasia");
		
		// the supplier interface doenot take any argument as input and but return value of type T		
		       Supplier<String> supplier = () -> "tushar";
		       System.out.println(supplier.get());
		       
		
		// the Predicate interface take one arguement as input and returns boolean value after evaluating the condition
	    Predicate<Integer> p1 = x -> x%2==0;
	    System.out.println(p1.test(8));
	    Predicate<Integer> p2 = x -> x%5==0;
	    System.out.println(p1.and(p2).test(10));
	    System.out.println(p1.or(p2).test(8));
	    System.out.println(p1.or(p2).negate().test(8));
		
	 // the Predicate interface take two arguement as input and returns boolean value after evaluating the condition
	    BiPredicate<String,String> bipredicate = (x,y) -> x.equals(y);
	    System.out.println(bipredicate.test("Tushar", "Tushar"));
	    
		//Function interface take one argument as input and return back an output
		Function<String, String> func = x -> x.toUpperCase();
		//String str = func.apply("This is Java 8");
		//System.out.println(str);
		
		
		Function<String, String> func1 = x -> x.toLowerCase();
		

		System.out.println(func.compose(func1).apply("This is java 8"));
		System.out.println(func.andThen(func1).apply("This is java 8"));
		
		
	
		
		Function<String, Integer> func2 = x -> x.length();
		
		Integer leng2 = func.andThen(func1).andThen(func2).apply("This is java 8");
        System.out.println(leng2);
        
        
      //BIFunction interface take two argument as input and return back an output
        BiFunction<Integer, Integer, Integer> bifunction = (x,y) -> x + y;
        Integer sum = bifunction.apply(15, 20);
        System.out.println(sum);
        
      //UnaryOperator interface take one argument as input and return back an output of same type
        UnaryOperator<String> uoperator = x -> x.concat(" - chaurasia");
        System.out.println(uoperator.apply("Tushar"));
        
        //BinaryOperator interface take two argument as input of same type and return back an output of same type
        BinaryOperator<Integer> bioperator = (x,y) -> x + y;
        Integer sum1 = bioperator.apply(15, 20);
        System.out.println(sum1);
        
	}

}
