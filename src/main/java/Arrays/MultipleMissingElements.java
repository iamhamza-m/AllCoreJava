package Arrays;

/**
 * This works for sorted array only.
 * Finds multiple missing elements in a sorted array by checking differences.
 */
public class MultipleMissingElements {
	public static void main(String[] args) {
		int[] givenArray = {6, 7, 8, 9, 11, 12, 15, 16, 17, 18, 19};
		int difference = givenArray[0];
		
		for (int i = 0; i < givenArray.length; i++) {
			if (givenArray[i] - i != difference) {
				while (difference < givenArray[i] - i) {
					System.out.println("The missing number is " + (i + difference));
					difference++;
				}
			}
		}
	}
}
