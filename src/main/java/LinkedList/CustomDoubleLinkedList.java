package LinkedList;

class NodeDouble{
	NodeDouble prev;
	int data;
	NodeDouble next;
	
	public NodeDouble(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

public class CustomDoubleLinkedList {
	
	private NodeDouble head;
	private NodeDouble tail;
	
	public void add(int data) {
		NodeDouble newNode = new NodeDouble(data);
		
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
	}
	
}


class CustomDoubleLinkedListMain{
	static void main(String[] args) {
	
	}
}