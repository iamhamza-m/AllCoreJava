package Trees;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;

class TreeLinked {
	int value;
	TreeLinked left, right;
	
	TreeLinked(int value) {
		this.value = value;
	}
}

public class TreeUdemyImplementation {
	static TreeLinked buildTree(int @NotNull [] values) {
		if (values.length == 0) return null;
		
		TreeLinked root = new TreeLinked(values[0]);
		Queue<TreeLinked> queue = new LinkedList<>();
		queue.offer(root);
		
		int i = 1;
		while (i < values.length) {
			TreeLinked current = queue.poll();
			// Left child
			current.left = new TreeLinked(values[i++]);
			queue.offer(current.left);
			if (i < values.length) {
				// Right child
				current.right = new TreeLinked(values[i++]);
				queue.offer(current.right);
			}
		}
		
		return root;
	}
	
	static void traverse(TreeLinked node){
		if(node != null){
			System.out.print(" " + node.value);
			traverse(node.left);
			traverse(node.right);
		}
	}
	
	static int countNodes(TreeLinked root) {
		if (root == null) return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	static void main(String[] args) {
		int[] values = {1,3,4,5,67,2,1,3,1};
		TreeLinked root = buildTree(values);
		traverse(root);
		System.out.println("\n Total nodes are " + countNodes(root));
	}
}