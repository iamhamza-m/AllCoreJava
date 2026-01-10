package Sorting;

/**
 * Merge sort algorithm.
 */
public class MergeSort {
	public static void Merge(int[] array, int low, int mid, int high) {
		int n1 = mid - low + 1;
		int n2 = high - mid;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		System.arraycopy(array, low, left, 0, n1);
		System.arraycopy(array, mid + 1, right, 0, n2);
		
		int i = 0, j = 0, k = low;
		
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[j++];
			}
		}
		
		while (i < n1) {
			array[k++] = left[i++];
		}
		
		while (j < n2) {
			array[k++] = right[j++];
		}
	}
	
	public static void MergeSort(int[] array, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			MergeSort(array, low, mid);
			MergeSort(array, mid + 1, high);
			Merge(array, low, mid, high);
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] givenArray = {
				42, 7, 189, 1, 18, 99
		};
		
		int length = givenArray.length - 1;
		
		MergeSort(givenArray, 0, length);
		
		for (int num : givenArray) {
			System.out.println(num);
		}
		
	}
}
