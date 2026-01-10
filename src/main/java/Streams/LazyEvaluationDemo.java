package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates lazy evaluation in streams.
 */
public class LazyEvaluationDemo {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Alice", "Wonderland", "Hobbit");
		
		Stream<String> namesStream = names.stream()
											 .filter(name -> {
												 System.out.println("Filtering " + name);
												 return name.length() > 3;
											 });
		
		System.out.println("Before terminal operation");
		
		List<String> filteredNames = namesStream.collect(Collectors.toList());
		
		System.out.println("After terminal operation");
		System.out.println(filteredNames);
		
	}
}
