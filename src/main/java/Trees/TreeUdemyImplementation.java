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

public class TreeAsArray {
	static void main(String[] args) {
		
		int[] values = {1, 2, 3, 4, 5, 6};
		
		TreeLinked root = buildTree(values);
		
		printLevelOrder(root);
		printTreePretty(root, 0);
	}
	
	static TreeLinked buildTree(int @NotNull [] values) {
		if (values.length == 0) return null;
		
		TreeLinked root = new TreeLinked(values[0]);
		Queue<TreeLinked> queue = new LinkedList<>();
		queue.offer(root);
		
		int i = 1;
		
		while (i < values.length) {
			TreeLinked current = queue.poll();
			
			// Left child
			assert current != null;
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
	
	static void printLevelOrder(TreeLinked root) {
		Queue<TreeLinked> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeLinked node = queue.poll();
			System.out.print(node.value + " ");
			
			if (node.left != null) queue.offer(node.left);
			if (node.right != null) queue.offer(node.right);
		}
		System.out.println();
	}
	
	static void printTreePretty(TreeLinked root, int level) {
		if (root == null) return;
		
		printTreePretty(root.right, level + 1);
		
		for (int i = 0; i < level; i++) {
			System.out.print("    ");
		}
		System.out.println(root.value);
		
		printTreePretty(root.left, level + 1);
	}
}