package Trees;

class BSTNode {
	int data;
	BSTNode left, right;
	
	BSTNode(int data) {
		this.data = data;
	}
}

class BSTStructure {
	
	// Iterative Insert
	BSTNode insert(BSTNode root, int value) {
		
		BSTNode newNode = new BSTNode(value);
		
		if (root == null) {
			return newNode;
		}
		
		BSTNode current = root;
		BSTNode parent = null;
		
		while (current != null) {
			parent = current;
			
			if (value < current.data) {
				current = current.left;
			} else if (value > current.data) {
				current = current.right;
			} else {
				return root;
			}
		}
		
		if (value < parent.data) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		
		return root;
	}
	
	// Build BST iteratively
	BSTNode createTree(int[] values) {
		BSTNode root = null;
		
		for (int value : values) {
			root = insert(root, value);
		}
		
		return root;
	}
	
	// Inorder traversal (should print sorted order)
	void printTree(BSTNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			printTree(root.left);
			printTree(root.right);
		}
	}
}

public class BinarySearchTreeIterative {
	
	static void main(String[] args) {
		
		int[] values = {28, 45, 12, 100, 43, 12, 344, 5, 11, 56, 53, 74};
		
		BSTStructure tree = new BSTStructure();
		BSTNode root = tree.createTree(values);
		
		System.out.println("Inorder Traversal (Should be Sorted):");
		tree.printTree(root);
	}
}
