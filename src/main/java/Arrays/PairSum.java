package Arrays;

/**
 * Finds pairs in a sorted array that sum to a given value k using two-pointer technique.
 */
public class PairSum {
	public static void main(String[] args) {
		int[] givenArray = {2, 3, 4, 5, 6, 7, 8, 10, 12, 99};
		int i = 0;
		int j = givenArray.length - 1;
		int k = 10;
		
		while (i < j) {
			if (givenArray[i] + givenArray[j] == k) {
				System.out.printf("The pair is %d and %d with summation equals to %d \n", givenArray[i], givenArray[j], k);
				i++;
				j--;
			} else if (givenArray[i] + givenArray[j] < k) {
				i++;
			} else if (givenArray[i] + givenArray[j] > k) {
				j--;
			}
		}
	}
}
