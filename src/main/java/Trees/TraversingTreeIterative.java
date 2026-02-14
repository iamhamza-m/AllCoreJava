package Trees;

import java.util.Scanner;
import java.util.Stack;

class TraverseNodeIterative {
	int data;
	TraverseNodeIterative left, right;
	
	TraverseNodeIterative(int data) {
		this.data = data;
	}
}

class TraverseTreeClass {
	
	// -------------------------
	// Recursive Tree Creation
	// -------------------------
	TraverseNodeIterative createTree(Scanner scanner, boolean isRoot) {
		if (isRoot) {
			System.out.println("Enter root node:");
		}
		
		int data = scanner.nextInt();
		
		if (data == -1)
			return null;
		
		TraverseNodeIterative node = new TraverseNodeIterative(data);
		
		System.out.printf("Add left node to %d: ", data);
		node.left = createTree(scanner, false);
		
		System.out.printf("Add right node to %d: ", data);
		node.right = createTree(scanner, false);
		
		return node;
	}
	
	// -------------------------
	// Iterative Preorder
	// Root → Left → Right
	// -------------------------
	void preorderTraversal(TraverseNodeIterative root) {
		if (root == null) return;
		
		Stack<TraverseNodeIterative> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TraverseNodeIterative node = stack.pop();
			System.out.print(" " + node.data);
			
			if (node.right != null) stack.push(node.right);
			if (node.left != null) stack.push(node.left);
		}
	}
	
	// -------------------------
	// Iterative Inorder
	// Left → Root → Right
	// -------------------------
	void inOrderTraversal(TraverseNodeIterative root) {
		Stack<TraverseNodeIterative> stack = new Stack<>();
		TraverseNodeIterative current = root;
		
		while (current != null || !stack.isEmpty()) {
			
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			System.out.print(" " + current.data);
			
			current = current.right;
		}
	}
	
	// -------------------------
	// Iterative Postorder
	// Left → Right → Root
	// (Using two stacks)
	// -------------------------
	void postOrderTraversal(TraverseNodeIterative root) {
		if (root == null) return;
		
		Stack<TraverseNodeIterative> stack1 = new Stack<>();
		Stack<TraverseNodeIterative> stack2 = new Stack<>();
		
		stack1.push(root);
		
		while (!stack1.isEmpty()) {
			TraverseNodeIterative node = stack1.pop();
			stack2.push(node);
			
			if (node.left != null) stack1.push(node.left);
			if (node.right != null) stack1.push(node.right);
		}
		
		while (!stack2.isEmpty()) {
			System.out.print(" " + stack2.pop().data);
		}
	}
}

public class TraversingTreeIterative {
	
	static void main(String[] args) {
		
		TraverseTreeClass tree = new TraverseTreeClass();
		Scanner scanner = new Scanner(System.in);
		
		TraverseNodeIterative root = tree.createTree(scanner, true);
		
		System.out.println("\nPreorder (Iterative):");
		tree.preorderTraversal(root);
		
		System.out.println("\nInorder (Iterative):");
		tree.inOrderTraversal(root);
		
		System.out.println("\nPostorder (Iterative):");
		tree.postOrderTraversal(root);
	}
}