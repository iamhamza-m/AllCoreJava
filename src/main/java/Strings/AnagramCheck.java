package Strings;

/**
 * Checks if two strings are anagrams using frequency count.
 */
public class AnagramCheck {
	
	public static boolean areAnagrams(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		
		int[] freq = new int[26];
		
		for (int i = 0; i < s1.length(); i++) {
			freq[s1.charAt(i) - 'a']++;
			freq[s2.charAt(i) - 'a']--;
		}
		
		for (int count : freq) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str1 = "listen";
		String str2 = "silent";
		
		if (areAnagrams(str1, str2)) {
			System.out.println("Strings are anagrams");
		} else {
			System.out.println("Strings are NOT anagrams");
		}
	}
}
