package Strings;

/**
 * Generates all permutations of a string using recursion.
 */
public class PermutationString {
	
	public static void permutation(char[] s, int l, int h) {
		
		if (l == h) {
			System.out.println(new String(s));
		} else {
			for (int i = l; i <= h; i++) {
				
				// swap
				char temp = s[l];
				s[l] = s[i];
				s[i] = temp;
				
				permutation(s, l + 1, h);
				
				// backtrack
				temp = s[l];
				s[l] = s[i];
				s[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		String given = "ABCD";
		permutation(given.toCharArray(), 0, given.length() - 1);
	}
}
