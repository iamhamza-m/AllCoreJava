package Stacks;

class NodeParenthesis {
	char data;
	NodeParenthesis next;
	
	NodeParenthesis(char data) {
		this.data = data;
		this.next = null;
	}
}

class StackLinkedListParenthesis {
	NodeParenthesis head;
	
	boolean isEmpty() {
		return head == null;
	}
	
	void push(char data) {
		NodeParenthesis newNode = new NodeParenthesis(data);
		newNode.next = head;
		head = newNode;
	}
	
	char pop() {
		if (isEmpty()) {
			throw new RuntimeException("The stack is empty");
		}
		char value = head.data;
		head = head.next;
		return value;
	}
	
	void print() {
		NodeParenthesis current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
}

public class ParenthesisMatching {
	
	public static void main(String[] args) {
		
		String input = "{([a+b] * [c-d])/e}";
		char[] inputArray = input.toCharArray();
		
		StackLinkedListParenthesis list = new StackLinkedListParenthesis();
		
		for (char value : inputArray) {
			
			if (value == '{' || value == '(' || value == '[') {
				list.push(value);
			}
			
			if (value == '}' || value == ')' || value == ']') {
				
				if (list.isEmpty()) {
					System.out.println("Unbalanced expression");
					return;
				}
				
				char popped = list.pop();
				
				if ((value == '}' && popped != '{') ||
							(value == ')' && popped != '(') ||
							(value == ']' && popped != '[')) {
					
					System.out.println("Mismatched parentheses");
					return;
				}
			}
		}
		
		System.out.println("Stack current status:");
		list.print();
		
		if (list.isEmpty()) {
			System.out.println("Expression is balanced");
		} else {
			System.out.println("Expression is NOT balanced");
		}
	}
}