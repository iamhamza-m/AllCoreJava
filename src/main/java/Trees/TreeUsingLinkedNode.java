package Trees;

import java.util.Scanner;

class TreeNode{
	int data;
	TreeNodeGenerate left, right;
	TreeNode(int data){
		this.data = data;
	}
}

class TreeImplementation{
	TreeNodeGenerate createTree(Scanner scanner, boolean isRoot){
		System.out.println(isRoot ? "Enter the root node : " : "");
		int data = scanner.nextInt();
		
		if(data == -1){
			return null;
		}
		
		TreeNodeGenerate root = new TreeNodeGenerate(data);
		
		System.out.print("Add left node for " + data);
		root.left = createTree(scanner, false);
		
		System.out.print("Add right node for " + data);
		root.right = createTree(scanner, false);
		
		return root;
	}
	
	int countNodes(TreeNodeGenerate root) {
		if (root == null) return 0;
		
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
}

public class TreeUsingLinkedNode {
	static void main(String[] args) {
		TreeImplementation tree = new TreeImplementation();
		Scanner scanner = new Scanner(System.in);
		TreeNodeGenerate root = tree.createTree(scanner, true);
		System.out.println(" \n " + tree.countNodes(root));
	}
}
