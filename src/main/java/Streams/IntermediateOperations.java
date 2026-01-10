package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Demonstrates intermediate stream operations like filter, map, flatMap, etc.
 */
public class IntermediateOperations {
	public static void main(String[] args) {
		// Intermediate operations transform a stream into another stream
		// They are lazy, meaning they don't execute until a terminal operation is invoked.
		
		// 1. filter
		List<String> list = Arrays.asList("Akshit", "Ram", "Krishna", "Sita", "Lakshman");
		list.stream().filter(x -> x.startsWith("K")).forEach(System.out::println);
		
		// 2. map
		list.stream().map(String::toUpperCase).forEach(System.out::println);
		
		// 3. sorted
		list.stream().sorted().forEach(System.out::println);
		
		// 4. distinct
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3);
		numbers.stream().distinct().forEach(System.out::println);
		
		// 5. limit
		numbers.stream().limit(3).forEach(System.out::println);
		
		// 6. skip
		numbers.stream().skip(3).forEach(System.out::println);
		
		// 7. flatMap
		List<List<String>> listOfLists = Arrays.asList(
				Arrays.asList("a", "b"),
				Arrays.asList("c", "d")
		);
		System.out.println(listOfLists.stream().flatMap(x -> x.stream()).toList());
		listOfLists.stream().flatMap(List::stream).skip(1).limit(1).forEach(System.out::println);
		System.out.println(listOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());
		List<String> sentences = Arrays.asList(
				"Hello world",
				"Java streams are powerful",
				"flatMap is useful"
		);
		System.out.println(sentences
								   .stream()
								   .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
								   .map(String::toUpperCase)
								   .toList());
		
		
	}
}
