/**
 * This code shows infix to postfix conversion using a custom stack.
 * Handles operators +, -, *, /, %, ^ and parentheses ( ).
 */

package Stacks;

class NodeInfixToPostfixV2 {
	char data;
	NodeInfixToPostfixV2 next;
	
	NodeInfixToPostfixV2(char data) {
		this.data = data;
	}
}


class CustomOperatorStack {
	NodeInfixToPostfixV2 head;
	
	void push(char data) {
		NodeInfixToPostfixV2 newNode = new NodeInfixToPostfixV2(data);
		newNode.next = head;
		head = newNode;
	}
	
	boolean isEmpty() {
		return head == null;
	}
	
	char pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		char value = head.data;
		head = head.next;
		return value;
	}
	
	char peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return head.data;
	}
	

	boolean isOperand(char ch) {
		return Character.isLetterOrDigit(ch);
	}
	

	int precedence(char ch) {
		return switch (ch) {
			case '+', '-' -> 1;
			case '*', '/', '%' -> 2;
			case '^' -> 3;
			default -> 0;
		};
	}
	
	boolean isRightAssociative(char ch) {
		return ch == '^';
	}
}

public class InfixToPostfixWithParentheses {
	
	static void main(String[] args) {
		
		CustomOperatorStack stack = new CustomOperatorStack();
		
		char[] infix = {'(', 'a', '+', 'b', ')', '*', 'c', '^', 'd', '-', 'e'};
		StringBuilder postfix = new StringBuilder();
		
		for (char ch : infix) {
			
			if (stack.isOperand(ch)) {
				postfix.append(ch);
			}
			
			else if (ch == '(') {
				stack.push(ch);
			}
			
			else if (ch == ')') {
				while (!stack.isEmpty()
							   && stack.peek() != '(') {
					postfix.append(stack.pop());
				}
				stack.pop();
			}
			
			else {
				while (!stack.isEmpty()  && stack.peek() != '('
							   && (stack.precedence(ch) < stack.precedence(stack.peek())
										   || (stack.precedence(ch) == stack.precedence(stack.peek())
													   && !stack.isRightAssociative(ch)))) {
					
					postfix.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		
	
		while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
		
		System.out.println("Infix expression  : " + new String(infix));
		System.out.println("Postfix expression: " + postfix);
	}
}