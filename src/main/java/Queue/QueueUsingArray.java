package Queue;


public class QueueUsingArray {
	
	private int[] queue;
	private int front, rear, size;
	private final int capacity;
	
	public QueueUsingArray(int capacity) {
		this.capacity = capacity;
		queue = new int[capacity];
		front = 0;
		rear = -1;
		size = 0;
	}
	
	public void enqueue(int value) {
		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}
		rear = (rear + 1) % capacity;
		queue[rear] = value;
		size++;
	}
	
	
	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		int removed = queue[front];
		front = (front + 1) % capacity;
		size--;
		return removed;
	}
	

	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		return queue[front];
	}
	

	public boolean isEmpty() {
		return size == 0;
	}
	

	public boolean isFull() {
		return size == capacity;
	}
	
	
	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		for (int i = 0; i < size; i++) {
			System.out.print(queue[(front + i) % capacity] + " ");
		}
		System.out.println();
	}
	
	
static void main(String[] args) {
		QueueUsingArray q = new QueueUsingArray(5);
		
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.display();   // 10 20 30
		
		System.out.println(q.dequeue()); // 10
		q.display();   // 20 30
		
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		q.display();   // 20 30 40 50 60
		
		System.out.println(q.peek()); // 20
	}
}