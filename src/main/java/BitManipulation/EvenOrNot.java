package BitManipulation;

/**
 * Checks if a number is even or odd using bitwise AND.
 */
public class EvenOrNot {
	public static void main(String[] args) {
		int num = 1023;
		if ((num & 1) == 0) {
			System.out.println("The number is even");
		} else {
			System.out.println("The number is odd");
		}
	}
}
