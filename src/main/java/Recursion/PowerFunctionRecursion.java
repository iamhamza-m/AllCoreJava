package Recursion;

/**
 * Recursive power function, optimized for even exponents.
 */
public class PowerFunctionRecursion {
	
	public static int power(int n, int m) {
		if (m == 0)
			return 1;
		return power(n, m - 1) * n;
	}
	
	public static int powerOptimized(int n, int m) {
		if (m == 0)
			return 1;
		
		if (m % 2 == 0)
			return powerOptimized(n * n, m / 2);
		
		else
			return n * powerOptimized(n * n, (m - 1) / 2);
	}
	
	
	public static void main(String[] args) {
		int result = power(2, 3);
		System.out.println("The result is " + result);
		
		int resultOptimized = powerOptimized(2, 19);
		System.out.println("The optimized result is " + resultOptimized);
	}
}
