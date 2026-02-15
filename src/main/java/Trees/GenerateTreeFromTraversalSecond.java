package Trees;

import java.util.HashMap;
import java.util.Map;

class TraversalTreeNodeSecond {
	int data;
	TraversalTreeNodeSecond left, right;
	
	TraversalTreeNodeSecond(int data) {
		this.data = data;
	}
}

public class GenerateTreeFromTraversalSecond {
	
	// Build tree entry method
	private static TraversalTreeNodeSecond buildTree(int[] preorder, int[] inorder) {
		
		Map<Integer, Integer> inorderMap = new HashMap<>();
		
		// Store inorder index for quick lookup
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		
		return build(preorder, 0, 0, inorder.length - 1, inorderMap);
	}
	
	// Recursive helper
	private static TraversalTreeNodeSecond build(int[] preorder, int preIndex, int inLeft, int inRight, Map<Integer, Integer> inorderMap) {
		
		if (inLeft > inRight) return null;
		
		int rootValue = preorder[preIndex];
		TraversalTreeNodeSecond root = new TraversalTreeNodeSecond(rootValue);
		
		int inorderIndex = inorderMap.get(rootValue);
		int leftSubtreeSize = inorderIndex - inLeft;
		
		// Build left subtree
		root.left = build(
				preorder,
				preIndex + 1,
				inLeft,
				inorderIndex - 1,
				inorderMap
		);
		
		// Build right subtree
		root.right = build(
				preorder,
				preIndex + 1 + leftSubtreeSize,
				inorderIndex + 1,
				inRight,
				inorderMap
		);
		
		return root;
	}
	
	// Inorder traversal (for verification)
	private static void printInorder(TraversalTreeNodeSecond root) {
		if (root == null) return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}
	
	// Preorder traversal (for verification)
	private static void printPreorder(TraversalTreeNodeSecond root) {
		if (root == null) return;
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
	
	public static void main(String[] args) {
		
		int[] inorder = {1, 3, 4, 5, 7, 10, 12, 15, 18, 20, 25, 30};
		int[] preorder = {10, 5, 3, 1, 4, 7, 20, 15, 12, 18, 30, 25};
		
		TraversalTreeNodeSecond root = buildTree(preorder, inorder);
		
		System.out.println("Inorder Traversal:");
		printInorder(root);
		
		System.out.println("\nPreorder Traversal:");
		printPreorder(root);
	}
}
