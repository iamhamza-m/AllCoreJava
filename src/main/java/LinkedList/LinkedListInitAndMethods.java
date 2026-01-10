package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListInitAndMethods {
	
	public static void main(String[] args) {
		
		/*
		 * Dynamic Size: LinkedList grows or shrinks dynamically at runtime.
		 * Maintains Insertion Order: Elements are stored in the order they are added.
		 * Allows Duplicates: Duplicate elements are allowed.
		 * Not Synchronized: By default, LinkedList is not thread-safe. To make Thread-safe we can use Collections.synchronizedList().
		 * Efficient Insertion/Deletion: Adding or removing elements at the beginning or middle is faster compared to ArrayList.
		 */
		
		/*
		 * LinkedList nodes cannot be accessed directly by index; elements must be accessed by traversing from the head.
		 */
		
		// Create a LinkedList
		LinkedList<String> list = new LinkedList<>();
		
		// Add elements
		list.add("One");
		list.add("Two");
		list.add("Three");
		list.add("Four");
		list.add("Five");
		list.add(0, "Ten"); //Add to a specific index.
		
		printList("After initial adds", list);
		
		// Add element at the beginning
		list.addFirst("NowFirstTen");
		printList("After addFirst", list);
		
		// Update first element
		list.set(0, "NowNewSet");
		printList("After set", list);
		
		// Remove by index
		list.remove(0);
		printList("After remove index 0", list);
		
		// Remove by value
		list.remove("Ten");
		printList("After remove value 'Ten'", list);
		
		// Access by index (O(n) for LinkedList)
		System.out.println("Element at index 1: " + list.get(1));
		
		// Iterate using Iterator
		System.out.print("Iterating list: ");
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		
		// Verify list is unchanged after iteration
		System.out.println("Element at index 1 after iteration: " + list.get(1));
	}
	
	private static void printList(String message, LinkedList<String> list) {
		System.out.println(message + " -> " + list);
	}
}