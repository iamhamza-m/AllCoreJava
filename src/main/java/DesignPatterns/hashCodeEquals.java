package DesignPatterns;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Demonstrates overriding equals and hashCode for custom objects in sets.
 */
public class hashCodeEquals {
	private String name;
	private int age = 0;
	
	public hashCodeEquals(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof hashCodeEquals that)) return false;
		return age == that.age && Objects.equals(name, that.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}

class hashCodeMainClass {
	public static void main(String[] args) {
		hashCodeEquals obj1 = new hashCodeEquals("Hamza", 28);
		hashCodeEquals obj2 = new hashCodeEquals("Hamza", 28);
		
		Set<hashCodeEquals> set = new HashSet<>();
		set.add(obj1);
		
		System.out.println(obj1.equals(obj2)); // true
		System.out.println(set.contains(obj2)); // ???
		
	}
}
