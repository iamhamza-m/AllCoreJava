package Recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Fibonacci with memoization to avoid redundant calculations.
 */
public class FibonacciMemoRecursion {
	
	static int[] memo;
	
	public static int fibonacci(int n) {
		if (n <= 1) {
			memo[n] = n;
			return n;
		} else {
			if (memo[n - 2] == -1) {
				memo[n - 2] = fibonacci(n - 2);
			}
			
			if (memo[n - 1] == -1) {
				memo[n - 1] = fibonacci(n - 1);
			}
			
			memo[n] = memo[n - 2] + memo[n - 1];
			return memo[n];
		}
	}
	
	public static void main(String[] args) {
		
		System.out.print("Please enter the number of terms: ");
		Scanner inputVal = new Scanner(System.in);
		
		int length = inputVal.nextInt();
		
		memo = new int[length];
		Arrays.fill(memo, -1);
		
		for (int i = 0; i < length; i++) {
			System.out.print(fibonacci(i) + " ");
		}
		
		inputVal.close();
	}
}
