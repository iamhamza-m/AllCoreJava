package Recursion;

/**
 * Tail-recursive Fibonacci.
 */
public class FibonacciRecursionSecond {
	public static void fibonacci(int n, int a, int b) {
		if (n == 0) {
			return;
		}
		System.out.println(a + " ");
		fibonacci(n - 1, b, a + b);
		
	}
	
	public static void main(String[] args) {
		fibonacci(10, 0, 1);
	}
}
