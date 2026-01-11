package LinkedList;

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.next = null; // next is null because this is the last node initially
	}
}


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

class CustomLinkedListMain {
	static void main(String[] args) {
		
		CustomLinkedList list = new CustomLinkedList();
		
		list.add(10);
		list.add(20);
		list.add(30);
		
		// Start traversal from the head node
		Node current = list.head;
		
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next; // Move to the next node
		}
	}
}