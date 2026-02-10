package Stacks;

public class StacksInit {
	
	// Doubly Linked List Node
	private static class Node {
		int data;
		Node prev;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	private Node top;
	private int size;
	private final int capacity; // optional, for isFull()
	
	public StacksInit(int capacity) {
		this.capacity = capacity;
		this.top = null;
		this.size = 0;
	}
	
	// Push operation
	public void push(int value) {
		if (isFull()) {
			System.out.println("Stack Overflow");
			return;
		}
		
		Node newNode = new Node(value);
		newNode.next = top;
		
		if (top != null) {
			top.prev = newNode;
		}
		
		top = newNode;
		size++;
	}
	
	// Pop operation
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		
		int value = top.data;
		top = top.next;
		
		if (top != null) {
			top.prev = null;
		}
		
		size--;
		return value;
	}
	
	// Peek operation
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		return top.data;
	}
	
	// isEmpty
	public boolean isEmpty() {
		return top == null;
	}
	
	// isFull
	public boolean isFull() {
		return size == capacity;
	}
	
	// Demo
	public static void main(String[] args) {
		StacksInit stack = new StacksInit(3);
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		System.out.println("Peek: " + stack.peek()); // 30
		System.out.println("Pop: " + stack.pop());   // 30
		System.out.println("Pop: " + stack.pop());   // 20
		System.out.println("Pop: " + stack.pop());   // 10
		System.out.println("Is Empty: " + stack.isEmpty()); // True
		System.out.println("Is Full: " + stack.isFull()); // False
	}
}
