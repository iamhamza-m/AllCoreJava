package Recursion;

/**
 * Taylor series recursion for e^x.
 */
public class TaylorSeriesRecursion {
	
	static double p = 1;  // power
	static double f = 1;  // factorial
	
	static double taylor(int base, int power) {
		if (power == 0)
			return 1;
		
		double r = taylor(base, power - 1);
		
		p = p * base;      // x^n
		f = f * power;    // n!
		
		return r + p / f;
	}
	
	public static void main(String[] args) {
		
		double result = taylor(1, 10);
		System.out.println("The answer is : " + result);
		
	}
}
