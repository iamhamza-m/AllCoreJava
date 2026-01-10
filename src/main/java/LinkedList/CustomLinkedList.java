package LinkedList;

/*
 * Node represents a single element of the linked list.
 * Each node stores:
 * 1. data  → the value held by the node
 * 2. next  → reference to the next node in the list
 */
class Node {
	int data;
	Node next;
	
	// Constructor to initialize a node with data
	Node(int data) {
		this.data = data;
		this.next = null; // next is null because this is the last node initially
	}
}

/*
 * CustomLinkedList manages the linked list structure.
 * It maintains a reference to the first node (head).
 */
class CustomLinkedList {
	Node head; // Points to the first node of the list
	
	/*
	 * Adds a new node with the given data at the end of the list.
	 */
	void add(int data) {
		
		// Case 1: If the list is empty, create the first node
		if (head == null) {
			head = new Node(data);
			return;
		}
		
		// Case 2: Traverse the list to reach the last node and Attach the new node at the end
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}
}

/*
 * Entry point of the program.
 * Demonstrates:
 * 1. Creating a custom linked list
 * 2. Adding elements
 * 3. Traversing the list using node != null
 */
class CustomLinkedListMain {
	public static void main(String[] args) {
		
		// Create a new linked list
		CustomLinkedList list = new CustomLinkedList();
		
		// Add elements to the list
		list.add(10);
		list.add(20);
		list.add(30);
		
		// Start traversal from the head node
		Node current = list.head;
		
		/*
		 * Traverse the linked list.
		 * The loop continues until current becomes null,
		 * which means we have reached the end of the list.
		 */
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next; // Move to the next node
		}
	}
}