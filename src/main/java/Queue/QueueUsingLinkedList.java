package Queue;

class QueueNode{
	int data;
	QueueNode next;
	QueueNode(int data){
		this.data = data;
		this.next = null;
	}
}

class CustomQueueLinkedList{
	QueueNode front;
	QueueNode rear;
	
	void enqueue(int data){
		QueueNode newNode = new QueueNode(data);
		if(rear == null){
			front = rear = newNode;
			return;
		}
		
		rear.next = newNode;
		rear = newNode;
	}
	
	int dequeue(){
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		int value = front.data;
		front = front.next;
		
		if(front == null)
			rear = null;
		
		return value;
	}
	
	boolean isEmpty(){
		return front == null;
	}
	
	void printQueue(){
		QueueNode current = front;
		while (current != null){
			System.out.println(current.data);
			current = current.next;
		}
	}
}

public class QueueUsingLinkedList {
	static void main(String[] args) {
		CustomQueueLinkedList list = new CustomQueueLinkedList();
		list.enqueue(10);
		list.enqueue(20);
		list.enqueue(30);
		list.enqueue(40);
		
		list.printQueue();
		
		System.out.println("Popped value " + list.dequeue());
		
		list.printQueue();
		
	}
}
