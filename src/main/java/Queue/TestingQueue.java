package Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Tests PriorityQueue with custom Student class and comparator.
 */
public class TestingQueue {
	
	public static void main(String[] args) {
		PriorityQueue<Students> queue = new PriorityQueue<>(new Comparator<Students>() {
			@Override
			public int compare(Students o1, Students o2) {
				return o1.getRollNumber() - o2.getRollNumber();
			}
		});
		
		queue.offer(new Students(1, "Alice"));
		queue.offer(new Students(3, "Bob"));
		queue.offer(new Students(2, "Charlie"));
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
	
	public static class Students {
		private final int rollNumber;
		private final String name;
		
		public Students(int rollNumber, String name) {
			this.rollNumber = rollNumber;
			this.name = name;
		}
		
		public int getRollNumber() {
			return rollNumber;
		}
		
		public String getName() {
			return name;
		}
		
		@Override
		public String toString() {
			return "Students{" +
						   "rollNumber=" + rollNumber +
						   ", name='" + name + '\'' +
						   '}';
		}
	}
}
