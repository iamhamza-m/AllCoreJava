package Stacks;

import java.util.Scanner;

class StackBase {
	int size;
	int top;
	int[] array;
	
	// Constructor to keep initialization in one place
	StackBase(int size) {
		this.size = size;
		this.array = new int[size];
		this.top = -1;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == size - 1;
	}
	
	public void push(int data) {
		if (isFull()) {
			throw new RuntimeException("Stack overflow");
		}
		array[++top] = data;
	}
	
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return array[top--];
	}
	
	public void printStack() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		
		for (int i = 0; i <= top; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}

public class StackUsingArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your stack size");
		int size = input.nextInt();
		
		StackBase stack = new StackBase(size);
		
		stack.push(10);
		stack.push(12);
		stack.push(13);
		
		stack.printStack();
		
		stack.pop();
		
		stack.printStack();
	}
}