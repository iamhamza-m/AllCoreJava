package Queue;

class QueueNode{
	int data;
	QueueNode next;
	int size;
	QueueNode(int data){
		this.data = data;
		this.next = null;
		this.size = 0;
	}
}

class CustomQueueLinkedList{
	QueueNode head;
	
	void enqueue(int data){
		QueueNode newNode = new QueueNode(data);
		if(head == null){
			newNode.next = null;
			head = newNode;
			return;
		}
		
		QueueNode current = head;
		while (current.next != null){
			current = current.next;
		}
		
		newNode.next = null;
		current.next = newNode;
	}
	
	int dequeue(){
		if(isEmpty())
			throw new RuntimeException("Queue is empty");
		int value = head.data;
		head = head.next;
		return value;
	}
	
	boolean isEmpty(){
		return head == null;
	}
	
	void printQueue(){
		QueueNode current = head;
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
