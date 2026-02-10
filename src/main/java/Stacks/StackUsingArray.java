package Stacks;

import java.util.Scanner;

class ArrayStack {
	
	private int[] array;
	private int top;
	private int capacity;
	
	// Constructor
	public ArrayStack(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Stack size must be greater than 0");
		}
		this.capacity = capacity;
		this.array = new int[capacity];
		this.top = -1;
	}
	
	// Check if stack is empty
	public boolean isEmpty() {
		return top == -1;
	}
	
	// Check if stack is full
	public boolean isFull() {
		return top == capacity - 1;
	}
	
	// Push element onto stack
	public void push(int data) {
		if (isFull()) {
			throw new RuntimeException("Stack overflow");
		}
		array[++top] = data;
	}
	
	// Pop element from stack
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack underflow");
		}
		return array[top--];
	}
	
	// Peek top element
	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return array[top];
	}
	
	// Print stack (top to bottom)
	public void printStack() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		
		for (int i = top; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}

public class StackUsingArray {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter stack size: ");
		int size = input.nextInt();
		
		ArrayStack stack = new ArrayStack(size);
		
		stack.push(10);
		stack.push(12);
		stack.push(13);
		
		stack.printStack();
		
		System.out.println("Popped: " + stack.pop());
		
		stack.printStack();
		
		System.out.println("Top element: " + stack.peek());
	}
}