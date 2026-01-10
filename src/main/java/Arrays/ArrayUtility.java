package Arrays;

import java.util.Scanner;

/**
 * Utility class for inputting 1D and 2D arrays.
 */
public class ArrayUtility {
	public static int[] inputArray() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the number of elements in array : ");
		int arrSize = input.nextInt();
		int[] arr = new int[arrSize];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Please enter the element " + (i + 1) + " : ");
			arr[i] = input.nextInt();
		}
		return arr;
	}
	
	public static void printArray(int[] numArray) {
		for (int num : numArray) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static int[][] input2DArray() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the number of rows : ");
		int rows = input.nextInt();
		System.out.print("Please enter the number of columns : ");
		int columns = input.nextInt();
		
		int[][] array2D = new int[rows][columns];
		int i = 0;
		while (i < rows) {
			int j = 0;
			while (j < columns) {
				System.out.print("Please enter the element in position[" + i + "," + j + "] : ");
				array2D[i][j] = input.nextInt();
				j++;
			}
			System.out.println();
			i++;
		}
		
		return array2D;
	}
	
	public static void print2DAArray(int[][] numArray) {
		for (int i = 0; i < numArray.length; i++) {
			for (int j = 0; j < numArray[i].length; j++) {
				System.out.print(" " + numArray[i][j] + " ");
			}
			System.out.println();
		}
	}
}
