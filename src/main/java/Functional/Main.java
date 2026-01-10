package Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * Demonstrates functional interfaces: Predicate, Function, Consumer, Supplier, etc.
 */
public class Main {
	public static void main(String[] args) {
		
		
		//Predicates
		Predicate<Integer> predicate = x -> x % 2 == 0;
		Predicate<String> predicate1 = x -> x.charAt(0) == 'V';
		Predicate<String> predicate2 = x -> x.charAt(x.length() - 1) == 'd';
		Predicate<String> or = predicate1.or(predicate2);
		Predicate<String> and = predicate1.and(predicate2);
		Predicate<String> negate = predicate1.negate();
		
		System.out.println(predicate.test(4));
		System.out.println(predicate1.test("Vaid"));
		System.out.println(or.test("Vaid"));
		System.out.println(and.test("Vaid"));
		System.out.println(negate.test("Vaid"));
		
		// Functions
		Function<String, Integer> function = String::length;
		System.out.println(function.apply("Hamza"));
		
		Function<String, String> function1 = x -> x + "Vaid";
		System.out.println(function1.apply("Hamza "));
		
		Function<String, String> function2 = x -> x + "Vaid";
		System.out.println(function1.andThen(function2).apply("Hamza "));
		
		Function<String, String> function3 = x -> x + "Vaid";
		System.out.println(function1.compose(function3).apply("Hamza "));
		
		Function<String, String> function4 = Function.identity();
		System.out.println(function4.apply("Hamza"));
		
		// Consumer
		Consumer<String> consumer = x -> System.out.println(x + "Vaid");
		consumer.accept("Hamza ");
		
		Consumer<String> consumer1 = x -> System.out.println(x + "Vaid");
		consumer.andThen(consumer1).accept("Hamza ");
		
		// Supplier
		Supplier<String> supplier = () -> "Hamza Vaid";
		System.out.println(supplier.get());
		
		// BinaryOperator
		BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
		System.out.println(binaryOperator.apply(5, 6));
		
		// UnaryOperator
		UnaryOperator<Integer> unaryOperator = x -> x * x;
		System.out.println(unaryOperator.apply(5));
		
		// BiFunction
		BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;
		System.out.println(biFunction.apply(5, 6));
		
		// BiPredicate
		BiPredicate<Integer, Integer> biPredicate = (x, y) -> x > y;
		System.out.println(biPredicate.test(5, 6));
		
		// BiConsumer
		BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x + y);
		biConsumer.accept(5, 6);
		
		// Student example
		List<Student> students = new ArrayList<>();
		students.add(new Student("Hamza", 1));
		students.add(new Student("Vaid", 2));
		students.add(new Student("Khan", 3));
		
		Predicate<Student> studentPredicate = x -> x.getId() > 1;
		Function<Student, String> studentFunction = Student::getName;
		Consumer<Student> studentConsumer = x -> System.out.println(x.getName());
		Supplier<Student> studentSupplier = () -> new Student("Hamza", 1);

//        students.stream().filter(studentPredicate).map(studentFunction).forEach(studentConsumer);
//        System.out.println(studentSupplier.get());
	}
}

class Student {
	private String name;
	private int id;
	
	@Override
	public String toString() {
		return "Student{" +
					   "name='" + name + '\'' +
					   ", id=" + id +
					   '}';
	}
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
