package LinkedList;

import java.util.HashSet;

/**
 * Basic Node for singly linked list
 */
class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

/**
 * Simple wrapper to hold the head
 */
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

/**
 * All utility methods for linked list operations
 */
class CustomLinkedListMain {
	
	static void printNodes(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			printNodes(node.next);
		}
	}
	
	static void printWithMessage(String message, Node head) {
		System.out.print(message);
		printNodes(head);
		System.out.println();
	}
	
	// ====================== INSERTION / DELETION ======================
	
	static Node addNewNode(Node head, int data, int index) {
		if (index < 0) {
			System.out.println("Invalid index: " + index);
			return head;
		}
		
		Node newNode = new Node(data);
		
		// Insert at beginning
		if (index == 0) {
			newNode.next = head;
			return newNode;
		}
		
		Node current = head;
		int position = 0;
		
		while (current != null && position < index - 1) {
			current = current.next;
			position++;
		}
		
		if (current == null) {
			System.out.println("Index " + index + " out of range. Appending at end.");
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			return head;
		}
		
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
		
		if (current.next == null && position < index - 1) {
			System.out.printf("Index too big, removing last node (position %d)%n", position);
			Node temp = head;
			while (temp.next.next != null) {
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
	
	// ====================== PROPERTIES ======================
	
	static boolean isSorted(Node head) {
		boolean sorted = true;
		Node current = head;
		while (current.next != null) {  // Fixed safe condition (your original had .next.next)
			if (current.data > current.next.data) {
				sorted = false;
				break;
			}
			current = current.next;
		}
		return sorted;
	}
	
	// ====================== REMOVE DUPLICATES ======================
	
	// Brute force - O(n²)
	static Node removeDuplicates(Node head) {
		if (head == null) return null;
		
		Node current = head;
		
		while (current != null) {
			Node runner = current;
			
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
		
		return head;
	}
	
	// Better - O(n) time + O(n) space
	static Node removeDuplicatesBetter(Node head) {
		if (head == null) return null;
		
		HashSet<Integer> seen = new HashSet<>();
		Node current = head;
		Node prev = null;
		
		while (current != null) {
			if (seen.contains(current.data)) {
				prev.next = current.next;
			} else {
				seen.add(current.data);
				prev = current;
			}
			current = current.next;
		}
		
		return head;
	}
	
	// ====================== REVERSE ======================
	
	static Node reverseList(Node head) {
		Node high = head;
		Node mid = null;
		Node low;
		
		while (high != null) {
			low = mid;
			mid = high;
			high = high.next;
			mid.next = low;
		}
		
		return mid;
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
	
	// ====================== CONCAT & MERGE ======================
	
	static void concatenation(Node first, Node second) {
		if (first == null) {
			first = second;
			return;
		}
		
		Node temp = first;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = second;
	}
	
	static Node mergeSortedLists(Node l1, Node l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		Node head;
		Node tail;
		
		if (l1.data <= l2.data) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		
		tail = head;
		
		while (l1 != null && l2 != null) {
			if (l1.data <= l2.data) {
				tail.next = l1;
				l1 = l1.next;
			} else {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		
		tail.next = (l1 != null) ? l1 : l2;
		
		return head;
	}
	
	static Node mergeSortedListsRecursive(Node l1, Node l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		if (l1.data <= l2.data) {
			l1.next = mergeSortedListsRecursive(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeSortedListsRecursive(l1, l2.next);
			return l2;
		}
	}
	
	// ====================== LOOP CHECK ======================
	
	static boolean isLoopList(Node head){
		boolean isLoop = false;
		
		Node slowPointer = head;
		Node fastPointer = head;
		
		while (slowPointer != null && fastPointer != null){
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
			
			fastPointer = fastPointer.next == null ? null : fastPointer.next;
			
			if(slowPointer == fastPointer){
				isLoop = true;
				break;
			}
			
		}
		
		return isLoop;
	}
	
	// ====================== DISPLAY CIRCULAR LIST ===========
	
	static int flag = 0;
	static void displayCircularLinkedList(Node head){
		Node iterator = head;
		do {
			System.out.print(iterator.data + " ");
			iterator = iterator.next;
		} while (iterator != head);
	}
	
	// ====================== DELETING FROM CIRCULAR LIST =====
	
	static Node deletingNodeInCircular(Node head){
		if (head == null) {
			return null;
		}
		
		//Only one node
		if(head.next == null){
			return null;
		}
		
		//Last node
		Node temp = head;
		while(temp.next != head){
			temp = temp.next;
		}
		
		//Temp was on the last element.
		//That means the last element now points to head.next.
		//Also, the head now points to head.next.
		//This way we have successfully removed the head.
		temp.next = head.next;
		head = head.next;
		
		return head;
	}
	
	// ====================== ADDING INTO CIRCULAR LIST ======
	
	static Node addingNodeInCircular(Node head, Node insert){
		
		Node current = head;
		while (current.next != head){
			current = current.next;
		}
		
		current.next = insert;
		insert.next = head;
		
		return insert;
	}
	
	// ====================== MAIN DEMO ======================
	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		
		// More reasonable values
		int[] values = {10, 20, 30, 40, 50, 60, 70, 50, 30, 10};
		for (int val : values) {
			list.add(val);
		}
		
		printWithMessage("Original list:               ", list.head);
		
		list.head = addNewNode(list.head, 5, 0);
		printWithMessage("After add 5 at index 0:      ", list.head);
		
		list.head = addNewNode(list.head, 25, 3);
		printWithMessage("After add 25 at index 3:     ", list.head);
		
		list.head = addNewNode(list.head, 100, 15); // will append
		printWithMessage("After add 100 at index 15:   ", list.head);
		
		list.head = deletingNode(list.head, 4);
		printWithMessage("After delete index 4:        ", list.head);
		
		System.out.println("Is sorted?                   " + isSorted(list.head));
		System.out.println();
		
		list.head = removeDuplicates(list.head);
		printWithMessage("After removeDuplicates:      ", list.head);
		
		list.head = reverseList(list.head);
		printWithMessage("After reverse (iterative):   ", list.head);
		
		list.head = reverseListRecursive(list.head);
		printWithMessage("After reverse (recursive):   ", list.head);
		
		// Second list for concat/merge demo
		CustomLinkedList list2 = new CustomLinkedList();
		int[] values2 = {15, 25, 35, 45, 55, 65};
		for (int val : values2) {
			list2.add(val);
		}
		
		System.out.println("\nSecond list:                 ");
		printNodes(list2.head);
		System.out.println();
		
		// Concatenation demo
		Node concatHead = list.head;
		concatenation(concatHead, list2.head);
		printWithMessage("After concatenation:         ", concatHead);
		
		// Merge demo with two sorted lists
		CustomLinkedList sorted1 = new CustomLinkedList();
		sorted1.add(1);
		sorted1.add(4);
		sorted1.add(7);
		sorted1.add(12);
		sorted1.add(20);
		
		CustomLinkedList sorted2 = new CustomLinkedList();
		sorted2.add(2);
		sorted2.add(5);
		sorted2.add(8);
		sorted2.add(15);
		sorted2.add(25);
		
		System.out.println("Sorted List 1:               ");
		printNodes(sorted1.head);
		System.out.println();
		
		System.out.println("Sorted List 2:               ");
		printNodes(sorted2.head);
		System.out.println();
		
		Node mergedIter = mergeSortedLists(sorted1.head, sorted2.head);
		printWithMessage("Merged (iterative):          ", mergedIter);
		
		// Recursive merge on fresh copies
		CustomLinkedList sorted3 = new CustomLinkedList();
		sorted3.add(2);
		sorted3.add(5);
		sorted3.add(8);
		sorted3.add(13);
		sorted3.add(21);
		
		CustomLinkedList sorted4 = new CustomLinkedList();
		sorted4.add(3);
		sorted4.add(6);
		sorted4.add(9);
		sorted4.add(16);
		sorted4.add(26);
		
		System.out.println("Sorted List 3:               ");
		printNodes(sorted3.head);
		System.out.println();
		
		System.out.println("Sorted List 4:               ");
		printNodes(sorted4.head);
		System.out.println();
		Node mergedRec = mergeSortedListsRecursive(sorted3.head, sorted4.head);
		printWithMessage("Merged (recursive - small):  ", mergedRec);
		
		
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = a;
		
		System.out.println("Is this list a loop ? " + isLoopList(a));
		
		Node e = new Node(1);
		Node f = new Node(2);
		Node g = new Node(3);
		Node h = new Node(4);
		
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = null;
		
		System.out.println("Is this list a loop ? " + isLoopList(e));
		
		Node i = new Node(54);
		Node j = new Node(78);
		Node k = new Node(90);
		Node l = new Node(23);
		
		i.next = j;
		j.next = k;
		k.next = l;
		l.next = i;
		
		System.out.println("Displaying a circular linkedList : ");
		displayCircularLinkedList(i);
		System.out.println();
		
		i = deletingNodeInCircular(i);
		System.out.println("Displaying a circular linkedList post deletion : ");
		displayCircularLinkedList(i);
		
		System.out.println();
		
		i = addingNodeInCircular(i, new Node(77));
		System.out.println("Adding a new node in circular list: ");
		displayCircularLinkedList(i);
	}
}