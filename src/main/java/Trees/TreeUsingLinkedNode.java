package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode{
	int data;
	TreeNode left, right;
	TreeNode(int data){
		this.data = data;
	}
}

class TreeImplementation{
	TreeNode createTree(Scanner scanner, boolean isRoot){
		System.out.println(isRoot ? "Enter the root node : " : "");
		int data = scanner.nextInt();
		
		if(data == -1){
			return null;
		}
		
		TreeNode root = new TreeNode(data);
		
		System.out.print("Add left node for " + data);
		root.left = createTree(scanner, false);
		
		System.out.print("Add right node for " + data);
		root.right = createTree(scanner, false);
		
		return root;
	}
	
	void printTree(TreeNode root){
		if(root == null) return;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.print(node.data + " ");
			
			if (node.left != null) queue.offer(node.left);
			if (node.right != null) queue.offer(node.right);
		}
	}
}

public class TreeUsingLinkedNode {
	static void main(String[] args) {
		TreeImplementation tree = new TreeImplementation();
		Scanner scanner = new Scanner(System.in);
		TreeNode root = tree.createTree(scanner, true);
		tree.printTree(root);
	}
}
