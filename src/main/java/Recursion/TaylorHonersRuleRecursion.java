package Recursion;

/**
 * Taylor series using Horner's rule recursion.
 */
public class TaylorHonersRuleRecursion {
	
	// Computes e^x using Taylor series (Horner's Rule)
	static double taylor(int x, int n) {
		if (n == 0)
			return 1;
		
		return 1 + (x * taylor(x, n - 1)) / n;
	}
	
	public static void main(String[] args) {
		
		double result = taylor(1, 10);
		System.out.println("The answer is : " + result);
		
	}
}
