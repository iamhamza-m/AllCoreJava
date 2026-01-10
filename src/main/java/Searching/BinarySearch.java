package Searching;

import java.util.Arrays;

/**
 * Binary search on a sorted array.
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] findArray = {
				42, 7, 189, 56, 91, 3, 278, 64, 150, 23,
				88, 14, 302, 67, 5, 99, 211, 34, 76, 120,
				9, 245, 132, 78, 29, 167, 4, 210, 55, 87
		};
		Arrays.sort(findArray);
		
		int find = 99;
		int low = 0;
		int high = findArray.length - 1;
		int mid = 0;
		int answer = -1;
		
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (findArray[mid] == find) {
				answer = mid;
				break;
			} else if (findArray[mid] < find) {
				low = mid + 1;
			} else if (findArray[mid] > find) {
				high = mid - 1;
			}
		}
		
		System.out.println("Index found in sorted array " + answer);
	}
}
