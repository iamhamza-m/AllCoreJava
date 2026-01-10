package Recursion;

import java.util.Scanner;

/**
 * Checks if a string is palindrome using recursion.
 */
public class PalindromeRecursion {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to check if a string is a palindrome or not\n");
		System.out.print("Enter a string : ");
		String inputString = input.nextLine();
		if (isPalindrome(inputString, 0, inputString.length() - 1)) {
			System.out.println("The given string is palindrome");
		} else {
			System.out.println("The given string is not a palindrome");
		}
	}
	
	private static boolean isPalindrome(String str, int left, int right) {
		if (left >= right) {
			return true;
		}
		if (str.charAt(left) != str.charAt(right)) {
			return false;
		}
		return isPalindrome(str, left + 1, right - 1);
	}
}
