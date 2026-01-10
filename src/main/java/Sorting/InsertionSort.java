package Sorting;

/**
 * Insertion sort algorithm.
 */
public class InsertionSort {
	
	public static void main(String[] args) {
		
		int[] givenArray = {
				42, 7, 189, 56, 91, 3, 278, 64, 150, 23,
				88, 14, 302, 67, 5, 99, 211, 34, 76, 120,
				9, 245, 132, 78, 29, 167, 4, 210, 55, 87
		};
		
		for (int i = 1; i < givenArray.length; i++) {
			int key = givenArray[i];
			int j = i - 1;
			
			while (j >= 0 && givenArray[j] > key) {
				givenArray[j + 1] = givenArray[j];
				j--;
			}
			
			givenArray[j + 1] = key;
		}
		
		for (int num : givenArray) {
			System.out.println(num);
		}
	}
}
