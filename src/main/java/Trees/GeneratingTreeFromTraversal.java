package Trees;

import java.util.HashMap;
import java.util.Map;

class TreeNodeGenerate {
	int data;
	TreeNodeGenerate left, right;
	
	TreeNodeGenerate(int data) {
		this.data = data;
	}
}

class BuildTreeFromTraversals {
	
	private int preorderIndex = 0;
	private final Map<Integer, Integer> inorderMap = new HashMap<>();
	public TreeNodeGenerate buildTree(int[] preorder, int[] inorder) {
		// Store inorder index for fast lookup
		for (int i = 0; i < inorder.length; i++) {
			inorderMap.put(inorder[i], i);
		}
		return build(preorder, 0, inorder.length - 1);
	}
	
	private TreeNodeGenerate build(int[] preorder, int left, int right) {
		if (left > right) return null;
		
		int rootValue = preorder[preorderIndex++];
		TreeNodeGenerate root = new TreeNodeGenerate(rootValue);
		
		int inorderIndex = inorderMap.get(rootValue);
		
		root.left = build(preorder, left, inorderIndex - 1);
		root.right = build(preorder, inorderIndex + 1, right);
		
		return root;
	}
}

public class GeneratingTreeFromTraversal {
	static void printInorder(TreeNodeGenerate root) {
		if (root == null) return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}
	
	static void printPreorder(TreeNodeGenerate root) {
		if (root == null) return;
		System.out.print(root.data + " ");
		printPreorder(root.left);
		printPreorder(root.right);
	}
	
	static void main(String[] args) {
		int[] inorder = { 1, 3, 4, 5, 7, 10, 12, 15, 18, 20, 25, 30 };
		int[] preorder = { 10, 5, 3, 1, 4, 7, 20, 15, 12, 18, 30, 25 };
		
		BuildTreeFromTraversals builder = new BuildTreeFromTraversals();
		TreeNodeGenerate root = builder.buildTree(preorder, inorder);
		
		System.out.println("Inorder Traversal:");
		printInorder(root);
		
		System.out.println("\nPreorder Traversal:");
		printPreorder(root);
	}
}
