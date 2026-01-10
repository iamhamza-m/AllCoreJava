package Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Selection sort using ArrayList.
 */
public class SelectionSort {
	
	public static void main() {
		
		int[] givenArray = {
				42, 7, 189, 56, 91, 3, 278, 64, 150, 23,
				88, 14, 302, 67, 5, 99, 211, 34, 76, 120,
				9, 245, 132, 78, 29, 167, 4, 210, 55, 87
		};
		
		List<Integer> input = new ArrayList<>();
		for (int num : givenArray) {
			input.add(num);
		}
		
		List<Integer> sorted = new ArrayList<>();
		
		while (!input.isEmpty()) {
			int smallest = Integer.MAX_VALUE;
			int smallestIndex = -1;
			for (int i = 0; i < input.size(); i++) {
				if (input.get(i) < smallest) {
					smallest = input.get(i);
					smallestIndex = i;
				}
			}
			
			sorted.add(smallest);
			input.remove(smallestIndex);
		}
		
		System.out.println("Sorted array (selection sort using ArrayList): " + sorted);
	}
}
