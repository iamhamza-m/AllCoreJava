package Trees;

import java.util.Scanner;

class BSTSearchDeletionNode{
	int data;
	BSTSearchDeletionNode left,right;
	BSTSearchDeletionNode(int data){
		this.data = data;
	}
}

class BSTSearchDeletionMethods{
	BSTSearchDeletionNode buildTree(BSTSearchDeletionNode root, int data){
		if (root == null)
			root = new BSTSearchDeletionNode(data);
		
		if(data < root.data)
			root.left = buildTree(root.left, data);
		else if(data > root.data)
			root.right = buildTree(root.right, data);
		
		return root;
	}
	
	BSTSearchDeletionNode initTree(Scanner scanner){
		BSTSearchDeletionNode root = null;
		System.out.println("Enter your root node");
		int data = scanner.nextInt();
		while (data != -1){
			root = buildTree(root, data);
			System.out.println("Enter your node");
			data = scanner.nextInt();
		}
		
		return root;
	}
	
	int countNodes(BSTSearchDeletionNode root){
		if(root == null){
			return 0;
		}
		int x = countNodes(root.left);
		int y = countNodes(root.right);
		return x + y + 1;
	}
	
	int height(BSTSearchDeletionNode root){
		int x = 0;
		int y = 0;
		if(root == null) return 0;
		x = height(root.left);
		y = height(root.right);
		return Math.max(x, y) + 1;
	}
	

	
	
	BSTSearchDeletionNode deleteNode(BSTSearchDeletionNode root, int key) {
		
		if(root == null) return null;
		
		if(key > root.data)
			root.right = deleteNode(root.right, key);
		else if(key < root.data)
			root.left = deleteNode(root.left, key);
		else{
			if(root.left == null && root.right == null)
				return null;
			
			if(root.left == null)
				return root.right;
			
			if(root.right == null)
				return root.left;
			
			/**
			 * NOTE:
			 * The deletion logic below is correct, but calling height() inside every delete operation is expensive.
			 * Why?
			 *   - height() runs in O(n) time.
			 *   - delete() runs in O(h) time (h = height of tree).
			 *   - In the worst case (skewed tree), this can degrade to O(n²).
			 * In standard BST deletion, we typically:
			 *   - Always use the inorder successor, OR
			 *   - Always use the inorder predecessor.
			 * This avoids repeatedly computing subtree heights.
			 * Choosing replacement based on subtree height is theoretically valid,
			 * but it is inefficient and unnecessary for a normal BST.
			 **/
			
			if(height(root.left) > height(root.right)){
				BSTSearchDeletionNode predecessor = InOrderPredecessor(root.left);
				root.data = predecessor.data;
				root.left = deleteNode(root.left, predecessor.data);
			}
			else{
				BSTSearchDeletionNode successor = InOrderSuccessor(root.right);
				root.data = successor.data;
				root.right = deleteNode(root.right, successor.data);
			}
		}
		
		return root;
	}
	
	BSTSearchDeletionNode InOrderSuccessor(BSTSearchDeletionNode root){
		while (root.left != null){
			root = root.left;
		}
		return root;
	}
	
	BSTSearchDeletionNode InOrderPredecessor(BSTSearchDeletionNode root){
		while (root.right != null){
			root = root.right;
		}
		return root;
	}
	
	boolean ifPresent(BSTSearchDeletionNode root, int key){
		if(root == null) return false;
		if(key == root.data) return true;
		else if(key < root.data)  return ifPresent(root.left, key);
		else return ifPresent(root.right, key);
	}
}

public class BSTSearchDeletion {
	
	static void main(String[] args) {
		BSTSearchDeletionMethods tree = new BSTSearchDeletionMethods();
		Scanner scanner = new Scanner(System.in);
		BSTSearchDeletionNode root = tree.initTree(scanner);
		
		System.out.println("Total nodes in a tree are : " + tree.countNodes(root));
		System.out.println("Height of the tree is : " + tree.height(root));
		System.out.println("The val is present " + tree.ifPresent(root, 13));
		root = tree.deleteNode(root, 13);
		System.out.println("The val is present " + tree.ifPresent(root, 13));
	}

}


