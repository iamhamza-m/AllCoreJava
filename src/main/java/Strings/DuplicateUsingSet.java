package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Finds duplicates using Set.
 */
public class DuplicateUsingSet {
	
	public static void main(String[] args) {
		String input = "madam";
		
		Set<Character> seen = new HashSet<>();
		List<Character> duplicates = new ArrayList<>();
		
		for (char c : input.toCharArray()) {
			if (seen.contains(c)) {
				duplicates.add(c);
			} else {
				seen.add(c);
			}
		}
		
		System.out.println("Duplicate letters: " + duplicates);
	}
}
