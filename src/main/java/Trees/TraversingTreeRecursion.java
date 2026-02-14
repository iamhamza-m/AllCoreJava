package Trees;

import java.util.Scanner;

class TraverseNode{
	int data;
	TraverseNode left, right;
	TraverseNode(int data){
		this.data = data;
	}
}

class TraverseTree{
	TraverseNode createTree(Scanner scanner, boolean isRoot){
		if (isRoot) {
			System.out.println("Enter root node");
		}
		int data = scanner.nextInt();
		
		if(data == -1)
			return null;
		
		TraverseNode node = new TraverseNode(data);
		
		System.out.printf("Add left node to %d ", data);
		node.left = createTree(scanner, false);
		
		System.out.printf("Add right node to %d ", data);
		node.right = createTree(scanner, false);
		
		return node;
		
	}
	
	void preorderTraversal(TraverseNode node){
		if(node != null){
			System.out.print(" " + node.data);
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}
	
	void inOrderTraversal(TraverseNode node){
		if(node != null){
			inOrderTraversal(node.left);
			System.out.print(" " + node.data);
			inOrderTraversal(node.right);
		}
	}
	
	void postOrderTraversal(TraverseNode node){
		if(node != null){
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(" " + node.data);
		}
	}
	
	int countNodes(TraverseNode root) {
		if (root == null) return 0;
		
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
}

public class TraversingTreeRecursion {
	static void main(String[] args) {
		//Create a tree.
		TraverseTree tree = new TraverseTree();
		Scanner scanner = new Scanner(System.in);
		TraverseNode node = tree.createTree(scanner, true);
		
		//Pre-order Traversal
		tree.preorderTraversal(node);
		System.out.println();
		
		//In-order Traversal
		tree.inOrderTraversal(node);
		System.out.println();
		
		//Post-order Traversal
		tree.postOrderTraversal(node);
		
		System.out.println("\n " + tree.countNodes(node));
	}
}
