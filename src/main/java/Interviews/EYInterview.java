package Interviews;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * EY Interview questions: Find first non-repeating character.
 */
public class EYInterview {
	public static void main(String[] args) {
		/**
		 * first non-repeating character
		 * "ababcde" output : c
		 * */
		
		String input = "ababcde";
		char[] inputArray = input.toCharArray();
		Map<Character, Integer> frequency = new HashMap<>();
		
		for (char ch : inputArray) {
			frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
		}
		
		for (char ch : inputArray) {
			if (frequency.get(ch) == 1) {
				System.out.println("The non-repeating one is " + ch);
				break;
			}
		}
		
		// Alternative using LinkedHashMap and streams
		String givenInput = "mississippiopqrst";
		
		Map<Character, Integer> freq = new LinkedHashMap<>();
		
		givenInput.chars()
				.mapToObj(c -> (char) c)
				.forEach(character -> freq.put(character, freq.getOrDefault(character, 0) + 1));
		
		freq.entrySet()
				.stream()
				.filter(e -> e.getValue() == 1)
				.findFirst()
				.ifPresent(e -> System.out.println("The non-repeating one is " + e.getKey()));
		
		
	}
}
