package Stacks;

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}


class StackLinkedList {
	Node head;
	
	boolean isEmpty() {
		return head == null;
	}
	
	void push(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		int value = head.data;
		head = head.next;
		return value;
	}
	
	int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return head.data;
	}
	
	void printStack() {
		Node current = head;
		while (current != null) {
			System.out.print(" " + current.data);
			current = current.next;
		}
	}
}

public class StackUsingLinkedList {
	
	static void main(String[] args) {
		StackLinkedList stackList = new StackLinkedList();
		stackList.push(10);
		stackList.push(12);
		stackList.push(14);
		
		stackList.printStack();
		
		System.out.println();
		
		stackList.pop();
		
		stackList.printStack();
		
		System.out.println();
		
		stackList.peek();
	}
	
}
