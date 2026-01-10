package Arrays;

import java.util.Arrays;

/**
 * Advanced array operations: sum, average, diagonals.
 */
public class PracticeBasicsPlus {
	public static void main(String[] args) {
		int[][] array2DNew = ArrayUtility.input2DArray();
		ArrayUtility.print2DAArray(array2DNew);
		int[] arrayNew = ArrayUtility.inputArray();
		ArrayUtility.printArray(arrayNew);
		int length = arrayNew.length;
		int Summation = Arrays.stream(arrayNew).sum();
		double average = Arrays.stream(arrayNew).average().orElse(0.0);
		System.out.println("Sum : " + Summation + " Average : " + average);
		
		// Diagonal sums for square matrix
		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < array2DNew.length; i++) {
			sum1 += array2DNew[i][i];
			sum2 += array2DNew[i][array2DNew.length - 1 - i];
		}
		System.out.println("First diagonal elements summation " + sum1);
		System.out.println("Second diagonal elements summation " + sum2);
		
		
		int sum3 = Arrays.stream(array2DNew).flatMapToInt(Arrays::stream).sum();
		double average2 = Arrays.stream(array2DNew).flatMapToInt(Arrays::stream).average().orElse(0.0);
		
		System.out.println("Sum : " + sum3 + " Average : " + average2);
	}
}
