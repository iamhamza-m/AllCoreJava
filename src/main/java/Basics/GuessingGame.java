package Basics;

import java.util.Scanner;

/**
 * Simple number guessing game.
 */
public class GuessingGame {
	int number;
	
	public void randomNumber() {
		number = (int) Math.ceil(Math.random() * 100);
	}
	
	public int guessIt(int num) {
		return num - number;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		GuessingGame game = new GuessingGame();
		game.randomNumber();
		System.out.println("Welcome to number guessing game\n");
		int value;
		int guessedNumber;
		do {
			System.out.print("Please enter your number : ");
			guessedNumber = input.nextInt();
			value = game.guessIt(guessedNumber);
			if (value == 0) {
				System.out.println("You have guessed the right number !");
			} else if (value > 0) {
				System.out.println("A little lower");
			} else {
				System.out.println("A little higher");
			}
		} while (value != 0);
	}
}
