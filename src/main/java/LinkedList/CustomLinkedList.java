package LinkedList;

import java.util.HashSet;

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class CustomLinkedList {
	Node head;
	
	void add(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(data);
	}
}

class CustomLinkedListMain {
	
	static void printNodes(Node node){
		if(node != null){
			System.out.print(node.data + " ");
			printNodes(node.next);
		}
	}
	
	static Node addNewNode(Node head, int data, int index) {
		if (index < 0) {
			System.out.println("Invalid index: " + index);
			return head;
		}
		
		Node newNode = new Node(data);
		
		// Case 1: Insert at beginning (index 0)
		if (index == 0) {
			newNode.next = head;
			return newNode;
		}
		
		// Case 2: Insert somewhere in the middle or end
		Node current = head;
		int position = 0;
		
		// Go to the node just before where we want to insert
		while (current != null && position < index - 1) {
			current = current.next;
			position++;
		}
		
		// If index is too large → we reached end of list
		if (current == null) {
			System.out.println("Index " + index + " is out of range. Appending at end.");
			// Find last node and append
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			return head;
		}
		
		// Normal insertion
		newNode.next = current.next;
		current.next = newNode;
		
		return head;
	}
	
	
	static Node deletingNode(Node head, int index) {
		
		if (head == null) {
			return null;
		}
		
		if (index == 0) {
			return head.next;
		}
		
		Node current = head;
		int position = 0;
		
		while (current.next != null && position < index - 1) {
			current = current.next;
			position++;
		}
		
		if(current.next == null && position < index - 1){
			System.out.printf("The given index is too big removing %d position(last) now", position );
			System.out.println();
			
			Node temp = head;
			while (temp.next.next != null){
				temp = temp.next;
			}
			temp.next = null;
			return head;
		}
		
		if (current.next != null) {
			current.next = current.next.next;
		}
		
		return head;
	}
	
	
	static boolean isSorted(Node head){
		boolean sorted = true;
		Node current = head;
		while (current.next.next != null){
			if(current.data > current.next.data){
				sorted = false;
				break;
			}
			current = current.next;
		}
		return sorted;
	}
	
	//Oder of n^2.
	static Node removeDuplicates(Node head) {
		
		if(head == null) return null;
		
		Node current = head;
		
		while (current != null){
			
			Node runner = current;
			
			while ( runner.next != null ){
				if (runner.next.data == current.data){
					runner.next = runner.next.next;
				}else{
					runner = runner.next;
				}
				
			}
			
			current = current.next;
		}
		
		return head;
	}
	
	//Order of n + Space Order of n
	static Node removeDuplicatesBetter(Node head) {
		
		if (head == null) return null;
		
		HashSet<Integer> seen = new HashSet<>();
		Node current = head;
		Node prev = null;
		
		while (current != null) {
			if (seen.contains(current.data)) {
				prev.next = current.next;   // delete duplicate
			} else {
				seen.add(current.data);
				prev = current;             // move prev only when not deleting
			}
			current = current.next;
		}
		
		return head;
	}
	
	//Order of n
	static Node reverseList(Node head) {
		Node high = head;
		Node mid = null;
		Node low;
		
		while ( high != null){
			low = mid;
			mid = high;
			high = high.next;
			mid.next = low;
		}
		
		return mid; // High is on null hence mid becomes the first now post changing the links.
	}
	
	static Node reverseListRecursive(Node head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		Node newHead = reverseListRecursive(head.next);
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}
	
	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(31);
		list.add(32);
		list.add(32);
		list.add(32);
		list.add(32);
		
		System.out.print("Original list: ");
		printNodes(list.head);
		System.out.println();
		
		// Examples of usage:
		list.head = addNewNode(list.head, 5, 0);     // at beginning
		System.out.print("After add 5 at index 0:   ");
		printNodes(list.head);
		System.out.println();
		
		list.head = addNewNode(list.head, 15, 2);    // between 10 and 20
		System.out.print("After add 15 at index 2:  ");
		printNodes(list.head);
		System.out.println();
		
		list.head = addNewNode(list.head, 99, 10);   // too big → append
		System.out.print("After add 99 at index 10: ");
		printNodes(list.head);
		System.out.println();
		
		
		
		list.head = deletingNode(list.head, 10);
		System.out.print("After deletion : ");
		printNodes(list.head);
		System.out.println();
		
		System.out.println("Is this array sorted: " + isSorted(list.head));
		
		list.head = removeDuplicates(list.head);
		System.out.println("After removing duplicates: ");
		printNodes(list.head);
		System.out.println();
		
		list.head = reverseList(list.head);
		System.out.println("After reversing: ");
		printNodes(list.head);
		System.out.println();
		
	}
}