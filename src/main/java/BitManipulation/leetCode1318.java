package BitManipulation;

/**
 * LeetCode 1318: Minimum Flips to Make a OR b Equal to c.
 * a = 0010
 * b = 0110
 * c = 0101
 */
public class leetCode1318 {
	
	public static void approachSecond() {
		int a = 2, b = 6, c = 5;
		int flip = 0;
		
		int first = (a | b) ^ c;
		int second = (a & b);
		
		while (first != 0) {
			if ((first & 1) == 1) {
				flip += (second & 1) == 1 ? 2 : 1;
			}
			first >>= 1;
			second >>= 1;
		}
		System.out.println("The total number of flips are : " + flip);
	}
	
	public static void main(String[] args) {
		// Main approach using bit manipulation
		int a = 2, b = 6, c = 5;
		int flip = 0;
		
		while (a != 0 || b != 0 || c != 0) {
			int bitOfa = a & 1;
			int bitOfb = b & 1;
			int bitOfc = c & 1;
			
			if (bitOfc == 0) {
				if (bitOfa == 1) flip++;
				if (bitOfb == 1) flip++;
			} else {
				if (bitOfa == 0 && bitOfb == 0) flip++;
			}
			
			// Shift bits
			a >>= 1;
			b >>= 1;
			c >>= 1;
		}
		
		System.out.println("The total number of flips are : " + flip);
		System.out.println("The total flips using second method");
		approachSecond();
	}
}
