package Strings;

/**
 * Finds duplicates using bit mask (for lowercase a-z).
 */
public class DuplicateUsingBitMask {
	
	// Works only for lowercase a–z
	public static void main(String[] args) {
		String input = "madam";
		
		int H = 0;
		
		for (char c : input.toCharArray()) {
			int mask = 1 << (c - 'a');
			
			if ((H & mask) != 0) {
				System.out.println("Duplicate letter: " + c);
			} else {
				H = H | mask;
			}
		}
	}
}
