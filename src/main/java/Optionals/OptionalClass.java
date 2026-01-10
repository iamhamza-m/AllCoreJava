package Optionals;

import java.util.Optional;

/**
 * Basic Optional usage.
 */
public class OptionalClass {
	public static void main(String[] args) {
		Optional<String> name1 = getName(1);
		System.out.println(name1.orElse("NA"));
	}
	
	private static Optional<String> getName(int id) {
		String name = null;  // or "Hamza"
		return Optional.ofNullable(name);
	}
}
