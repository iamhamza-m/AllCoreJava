package Functional;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates method references.
 */
public class Reference {
	public void print(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		Reference ref = new Reference();
		List<String> students = Arrays.asList("Alice", "Bob", "Charlie");
		students.forEach(ref::print);
		List<Students> collect = students.stream().map(Students::new).toList();
		collect.forEach(System.out::println);
		collect.forEach(x -> {
			System.out.println(x.getName());
		});
	}
}

class Students {
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Students(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Students{" +
					   "name='" + name + '\'' +
					   '}';
	}
}
