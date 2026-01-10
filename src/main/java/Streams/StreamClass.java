package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * Demonstrates stream operations: filter, sum, map, distinct, sorted.
 */
public class StreamClass {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 12};
		int sum = 0;
		int sum2 = Arrays.stream(arr)
						   .filter(e -> e % 2 == 0)
						   .sum();
		
		List<String> fruitsList = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
		List<String> filteredFruits = fruitsList.stream().filter(x -> x.startsWith("a")).toList();
		
		filteredFruits.forEach(System.out::println);
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		BiFunction<Integer, Integer, Integer> square = (x, y) -> x * y;
		
		List<Integer> collect1 = list.stream().filter(x -> x > 4).toList();
		
		collect1.forEach(System.out::println);
		
		list.forEach(x -> square.apply(x, x));
		
		List<Integer> collect2 = list.stream().map(x -> x / 10).distinct().sorted((a, b) -> b - a).toList();
		
		collect2.forEach(System.out::println);
		
	}
}
