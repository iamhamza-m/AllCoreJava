package Streams;

import java.util.List;

/**
 * Tests stream filter, reduce, max.
 */
public class FilterTest {
	public static void main(String[] args) {
		List<String> fruits = List.of("Apple", "Banana", "Orange", "Cherry", "Date");
		System.out.println("Size of list : " + fruits.size());
		
		for (String fruit : fruits) {
			System.out.println(fruit);
		}
		
		fruits.stream()
				.filter(fruit -> fruit.endsWith("e"))
				.forEach(fruit -> System.out.println("Filtered list is now : " + fruit));
		
		List<Integer> numbers = List.of(1, 5, 6, 765, 2234, 232, 1232, 111, 2, 3, 4);
		int sum = numbers.stream()
						  .reduce(0, (a, b) -> a + b);
		System.out.println("Sum of this array is :  " + sum);
		int max = numbers.stream()
						  .reduce(0, (a, b) -> a > b ? a : b);
		System.out.println("Maximum number is :" + max);
	}
}
