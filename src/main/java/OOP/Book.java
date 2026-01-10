package OOP;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Book class with static total and methods for borrow/return.
 */
public class Book {
	String title;
	String author;
	String isbn;
	
	static int totalBooks;
	
	public void borrowBooks() {
	
	}
	
	public void returnBooks() {
	
	}
	
	public static int getTotalBooks() {
		return totalBooks;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5};
		List<Integer> newList = Arrays.stream(array).boxed().collect(Collectors.toList());
		for (int i : newList) {
			System.out.println(i);
		}
		
		Course course = new Course();
		Scanner input = new Scanner(System.in);
		int day = input.nextInt();
		String category;
		
		category = day > 80 ? "High" : day > 50 && day < 80 ? "Moderate" : "Low";
		System.out.println(category);
	}
	
	public static void dummy() {
		Book book = new Book();
		System.out.println(book.title);
	}
	
	
}
