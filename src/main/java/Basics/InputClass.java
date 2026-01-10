package Basics;

import java.util.Scanner;

/**
 * Simple input and summation.
 */
public class InputClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter number1: ");
		int num1 = input.nextInt();
		System.out.print("Please enter number2: ");
		int num2 = input.nextInt();
		System.out.print("Sum is: ");
		System.out.println(summation(num1, num2));
	}
	
	private static int summation(int a, int b) {
		return a + b;
	}
}
