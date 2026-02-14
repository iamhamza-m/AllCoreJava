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
	
	static void main(String[] args) {
		int[] values = {1, 2, 3, 4, 5, 6};
		TreeLinked root = buildTree(values);
		traverse(root);
	}
}