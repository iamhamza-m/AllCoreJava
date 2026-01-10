package Basics;

import java.util.Scanner;

/**
 * Basic practice: swapping, loops, increment operators.
 */
public class PracticeBasics {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        /*
        System.out.println("Enter numbers a & b respectively :");
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        System.out.println("Swapping the values ...");
        swapIt(num1, num2);
        printingPost();
        // Additional loops and patterns can be added here
        */
	}
	
	private static void swapIt(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After swap: a = " + a + ", b = " + b);
	}
	
	private static void printingPost() {
		int a = 10;
		System.out.println("Pre-increment" + ++a);
		System.out.println("Post-increment" + a++);
	}
}
