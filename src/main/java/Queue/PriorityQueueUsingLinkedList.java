package Queue;

class PriorityQueueNode {
	int data;
	int priority;
	PriorityQueueNode next;
	
	PriorityQueueNode(int data, int priority) {
		this.data = data;
		this.priority = priority;
		this.next = null;
	}
}

class CustomPriorityQueueLinkedList {
	
	private PriorityQueueNode front;
	
	// Enqueue based on priority (lower value = higher priority)
	void enqueue(int data, int priority) {
		PriorityQueueNode newNode = new PriorityQueueNode(data, priority);
		
		// Case 1: Empty queue OR higher priority than front
		if (front == null || priority < front.priority) {
			newNode.next = front;
			front = newNode;
			return;
		}
		
		// Case 2: Traverse to find correct position
		PriorityQueueNode current = front;
		while (current.next != null && current.next.priority <= priority) {
			current = current.next;
		}
		
		newNode.next = current.next;
		current.next = newNode;
	}
	
	int dequeue() {
		if (isEmpty())
			throw new RuntimeException("Priority Queue is empty");
		
		int value = front.data;
		front = front.next;
		return value;
	}
	
	boolean isEmpty() {
		return front == null;
	}
	
	void printQueue() {
		PriorityQueueNode current = front;
		while (current != null) {
			System.out.println("Data: " + current.data + ", Priority: " + current.priority);
			current = current.next;
		}
	}
}

public class PriorityQueueUsingLinkedList {
	
	public static void main(String[] args) {
		CustomPriorityQueueLinkedList pq = new CustomPriorityQueueLinkedList();
		
		pq.enqueue(10, 3);
		pq.enqueue(20, 1);
		pq.enqueue(30, 4);
		pq.enqueue(40, 2);
		
		pq.printQueue();
		
		System.out.println("Dequeued value: " + pq.dequeue());
		
		pq.printQueue();
	}
}