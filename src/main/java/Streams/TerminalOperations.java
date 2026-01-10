package Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates terminal stream operations like collect, forEach, reduce, etc.
 */
public class TerminalOperations {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3);
		
		// 1. collect
		list.stream().skip(1).collect(Collectors.toList()).forEach(System.out::println);
		
		// 2. forEach
		list.stream().forEach(System.out::println);
		
		// 3. reduce
		int sum = list.stream().reduce(0, Integer::sum);
		System.out.println(sum);
		
		// 4. count
		long count = list.stream().count();
		System.out.println(count);
		
		// 5. anyMatch
		boolean anyMatch = list.stream().anyMatch(x -> x > 2);
		System.out.println(anyMatch);
		
		// 6. allMatch
		boolean allMatch = list.stream().allMatch(x -> x > 0);
		System.out.println(allMatch);
		
		// 7. noneMatch
		boolean noneMatch = list.stream().noneMatch(x -> x < 0);
		System.out.println(noneMatch);
		
		// 8. findFirst
		Optional<Integer> findFirst = list.stream().findFirst();
		findFirst.ifPresent(System.out::println);
		
		// 9. findAny
		Optional<Integer> findAny = list.stream().findAny();
		findAny.ifPresent(System.out::println);
		
		// 10. min
		Optional<Integer> min = list.stream().min(Integer::compareTo);
		min.ifPresent(System.out::println);
		
		// 11. max
		Optional<Integer> max = list.stream().max(Integer::compareTo);
		max.ifPresent(System.out::println);
		
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		// Example:  Counting Occurrences of a Character
		String sentence = "Hello world";
		System.out.println(sentence.chars().filter(x -> x == 'l').count());
		
		// Example
		// Streams cannot be reused after a terminal operation has been called
		Stream<String> stream = names.stream();
		stream.forEach(System.out::println);
		//List<String> list1 = stream.map(String::toUpperCase).toList(); // exception
		
	}
}
