package Stacks;

import java.util.Arrays;

class NodeInfixToPostfix {
	char data;
	NodeInfixToPostfix next;
	NodeInfixToPostfix(char data){
		this.data = data;
	}
}

class CustomInfixToPostfix{
	NodeInfixToPostfix head;
	
	void push(char data){
		NodeInfixToPostfix newNode = new NodeInfixToPostfix(data);
		newNode.next = head;
		head = newNode;
	}
	
	boolean isEmpty(){
		return head == null;
	}
	
	char pop(){
		if(isEmpty()){
			throw new RuntimeException("The stack is empty, cannot delete");
		}
		
		char value = head.data;
		head = head.next;
		
		return value;
	}
	
	void printStack(){
		NodeInfixToPostfix current = head;
		while (current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	boolean isOperand(char x){
		return x != '+' && x != '-' && x != '/';
	}
	
	int precedence(char x){
		if(x == '+' || x =='-')
			return 1;
		else if(x == '*' || x == '/')
			return 2;
		else
			return 0;
	}
	
	char peek(){
		return head.data;
	}
}

public class InfixToPostfix {
	static void main(String[] args) {
		CustomInfixToPostfix list = new CustomInfixToPostfix();

		char[] infix = {'a','+','b','*','c','/','d','+','e'};
		
		StringBuilder postfix = new StringBuilder();
		
		for (char c : infix) {
			if (list.isOperand(c)) {
				postfix.append(c);
			}
			
			else {
				while (!list.isEmpty() &&
							   list.precedence(c) <= list.precedence(list.peek())) {
					postfix.append(list.pop());
				}
				list.push(c);
			}
		}
		
	
		while (!list.isEmpty()) {
			postfix.append(list.pop());
		}
		
		StringBuilder infixString = new StringBuilder();
		
		for(char ch : infix){
			infixString.append(ch);
		}
		
		System.out.println("The infix expression is : " + infixString);
		System.out.println("The postfix expression is : " + postfix);
	}
}
