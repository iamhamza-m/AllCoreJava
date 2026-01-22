package Interviews;

/**
 * ITC Interview: Sort array of 0s, 1s, 2s using Dutch National Flag algorithm.
 */
public class ServiceBasedInterview {
	
	public static void swapNums(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
	
	public static void main(String[] args) {
		
		int[] givenArray = {1, 0, 1, 0, 0, 1, 1, 1, 2, 0, 1, 2, 0, 2, 2, 2};
		
		int low = 0;
		int mid = 0;
		int high = givenArray.length - 1;
		
		while (mid <= high) {
			if (givenArray[mid] == 0) {
				swapNums(givenArray, low, mid);
				low++;
				mid++;
			} else if (givenArray[mid] == 1) {
				mid++;
			} else { // givenArray[mid] == 2
				swapNums(givenArray, mid, high);
				high--;
			}
		}
		
		
		for (int num : givenArray) {
			System.out.print(num + " ");
		}
	}
}
