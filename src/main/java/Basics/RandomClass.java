package Basics;

/**
 * Generates random dice rolls.
 */
public class RandomClass {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int diceRoll = (int) (Math.random() * 6) + 1;
			System.out.println(diceRoll);
		}
	}
}
