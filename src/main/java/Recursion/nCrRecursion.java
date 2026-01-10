package Recursion;

/**
 * Computes nCr using factorial recursion.
 */
public class nCrRecursion {
	
	public static int factorial(int n) {
		if (n == 0) return 1;
		return n * factorial(n - 1);
	}
	
	public static int nCr(int n, int r) {
		int t1, t2, t3;
		
		t1 = factorial(n);
		t2 = factorial(r);
		t3 = factorial(n - r);
		
		return t1 / (t2 * t3);
	}
	
	public static void main(String[] args) {
		int answer = nCr(10, 2);
		System.out.println("The nCr value is :  " + answer);
	}
}
