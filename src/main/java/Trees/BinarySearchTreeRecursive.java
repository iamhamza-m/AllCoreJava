package Trees;

import java.util.Scanner;

class BSTRecursiveNode{
	int data;
	BSTRecursiveNode left, right;
	BSTRecursiveNode(int data){
		this.data = data;
	}
}

class BSTRecursiveStructure{
	BSTRecursiveNode createTree(BSTRecursiveNode root, int data){
		if(root == null){
			root = new BSTRecursiveNode(data);
		}
		
		if( data < root.data)
			root.left = createTree(root.left, data);
		else if( data > root.data)
			root.right = createTree(root.right, data);
		
		return root;
	}
	
	BSTRecursiveNode startTree(Scanner scanner){
		BSTRecursiveNode root = null;
		
		System.out.println("Enter value ");
		int data = scanner.nextInt();
		
		while (data != -1){
			root = createTree(root, data);
			System.out.println("Enter value ");
			data = scanner.nextInt();
		}
		
		return root;
	}
	
	void printTree(BSTRecursiveNode root){
		if(root != null){
			printTree(root.left);
			System.out.print(root.data + " ");
			printTree(root.right);
		}
	}
}

public class BinarySearchTreeRecursive {
	static void main(String[] args) {
		BSTRecursiveStructure tree = new BSTRecursiveStructure();
		Scanner scanner = new Scanner(System.in);
		BSTRecursiveNode root = tree.startTree(scanner);
		tree.printTree(root);
	}
}
