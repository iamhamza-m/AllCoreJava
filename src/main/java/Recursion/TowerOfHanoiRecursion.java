package Recursion;

import java.util.Scanner;

/**
 * Tower of Hanoi recursive solution.
 */
public class TowerOfHanoiRecursion {
	
	public static int counter = 0;
	
	public static void TOH(int n, String first, String second, String third) {
		if (n > 0) {
			TOH(n - 1, first, third, second);
			System.out.printf("Move disk from tower %s to tower %s", first, third);
			counter++;
			System.out.println();
			TOH(n - 1, second, first, third);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Please give the total number of discs you want to move.");
		Scanner input = new Scanner(System.in);
		int disks = input.nextInt();
		TOH(disks, "A", "B", "C");
		System.out.println("The total calls " + counter);
	}
}
