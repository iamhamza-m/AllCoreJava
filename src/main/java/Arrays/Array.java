package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates basic array operations in Java, including initialization, reversal, and alphabet printing.
 */
public class Array {
	
	public static void main(String[] args) {
		// Fixed-size array initialization
		int[] firstArray = new int[10];
		int[] secondArray = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] thirdArray = new int[]{9, 10, 11, 12, 13, 14, 15};
		
		// 2D array (matrix)
		int[][] matrix = new int[2][2];
		
		// Dynamic array using List
		List<Integer> dynamicArray = new ArrayList<>();
		
		// Example: Reverse an array
		int[] originalArray = {1, 2, 3, 4, 5};
		int len = originalArray.length;
		int[] reverseArray = new int[len];
		
		for (int i = len - 1, j = 0; j < len && i >= 0; j++, i--) {
			reverseArray[j] = originalArray[i];
		}
		
		// Print reversed array
		for (int num : reverseArray) {
			System.out.print(num + " ");
		}
		
		// Print alphabet from A to Z
		System.out.println();
		char alphabet = 'A';
		System.out.print(alphabet + " ");
		for (int i = 1; i < 26; i++) {
			alphabet++;
			System.out.print(alphabet + " ");
		}
	}
}
