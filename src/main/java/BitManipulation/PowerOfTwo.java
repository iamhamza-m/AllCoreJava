package BitManipulation;

/**
 * Checks if a number is a power of two using bitwise operation.
 */
public class PowerOfTwo {
	public static void main(String[] args) {
		int num = 4;
		if (num > 0 && (num & (num - 1)) == 0) {
			System.out.println("The number is a power of 2");
		} else {
			System.out.println("Not a power of 2");
		}
	}
}
