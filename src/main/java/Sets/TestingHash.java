package Sets;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Finds unique characters in a string using HashSet.
 */
public class TestingHash {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Set<Character> uniqueSet = new HashSet<>();
		System.out.print("Enter a string : ");
		String userInput = input.next();
		
		for (char ch : userInput.toCharArray()) {
			uniqueSet.add(ch);
		}
		
		System.out.printf("Your input string has %d unique characters mentioned below", uniqueSet.size());
		System.out.println();
		for (Character c : uniqueSet) {
			System.out.print(c + "");
		}
	}
}
