package Recursion;

import java.util.Scanner;

/**
 * Computes factorial using recursion.
 */
public class Factorial {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to factorial function");
		System.out.print("Please enter the number : ");
		int num = input.nextInt();
		int factorial = fact(num);
		System.out.println("The factorial of given number is : " + factorial);
	}
	
	public static int fact(int num) {
		System.out.println("Function being called for " + num);
		if (num == 1) {
			return 1;
		}
		return num * fact(num - 1);
	}
}
