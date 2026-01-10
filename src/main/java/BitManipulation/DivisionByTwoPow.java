package BitManipulation;

/**
 * Divides a number by 2 using right shift operator.
 */
public class DivisionByTwoPow {
	public static void main(String[] args) {
		int num = 134;
		int numHalf = num >> 1;
		System.out.println("The new num is " + numHalf);
	}
}
