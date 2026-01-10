package Arrays;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Finds and prints duplicate elements in an array with their frequencies using a LinkedHashMap to preserve order.
 */
public class DuplicateArrays {
	public static void main(String[] args) {
		int[] givenArray = {3, 3, 4, 4, 5, 6, 7, 8, 10, 10, 12, 34, 45, 67, 12};
		
		// Use LinkedHashMap to count frequencies while preserving insertion order
		Map<Integer, Integer> frequencyCounter = new LinkedHashMap<>();
		for (int j : givenArray) {
			frequencyCounter.put(j, frequencyCounter.getOrDefault(j, 0) + 1);
		}
		
		// Print duplicates
		frequencyCounter.forEach((x, y) -> {
			if (y > 1) {
				System.out.printf("The value %d and it's occurrence is %d \n", x, y);
			}
		});
	}
}
