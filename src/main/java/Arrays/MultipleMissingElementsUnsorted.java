package Arrays;

import java.util.Arrays;

/**
 * Finds missing elements in an unsorted array using a hash array technique.
 * Assumes positive integers starting from 1.
 */
public class MultipleMissingElementsUnsorted {
	public static void main(String[] args) {
		int[] firstArray = {3, 7, 1, 2, 9, 10, 13, 15, 17, 18, 15, 19, 20};
		int maximum = 0;
		
		// Find maximum value in array
		for (int num : firstArray) {
			if (num > maximum) {
				maximum = num;
			}
		}
		
		// Create hash array initialized to -1
		int[] hashArray = new int[maximum + 1];
		Arrays.fill(hashArray, -1);
		
		// Mark present numbers
		for (int num : firstArray) {
			hashArray[num] = num;
		}
		
		// Print missing numbers
		for (int i = 1; i < hashArray.length; i++) {
			if (hashArray[i] == -1) {
				System.out.printf("The number %d is missing ", i);
				System.out.println();
			}
		}
	}
}
