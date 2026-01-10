package Recursion;

/**
 * Sum of first n natural numbers using recursion.
 */
public class SumOfNaturalsRecursion {
	public static int sum(int n) {
		if (n == 0)
			return 0;
		
		return n + sum(n - 1);
	}
	
	public static void main(String[] args) {
		int result = sum(9901);
		System.out.println("The sum using recursion is " + result);
	}
}
