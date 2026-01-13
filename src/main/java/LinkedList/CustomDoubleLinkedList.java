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
	
	 NodeDouble head;
	 NodeDouble tail;
	
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
	
	// ====================== DISPLAY ======================
	
	public static void printDoubleListForward(NodeDouble head){
		NodeDouble current = head;
		
		while (current != null){
			System.out.print(current.data + " ");
			current = current.next;
		}
		
		System.out.println();
		
	}
	
	public static void printDoubleListBackward(NodeDouble head){
		NodeDouble current = head;
		
		while ( current.next != null){
			current = current.next;
		}
		
		while ( current != null){
			System.out.print(current.data + " ");
			current = current.prev;
		}
		
		System.out.println();
	
	}
	
	// ====================== DELETE ======================
	
	public static NodeDouble deleteNodeInDoubleList(NodeDouble head){
		
		if(head.next == null){
			return null;
		}
		

		
		NodeDouble current = head;
		current = head.next;
		
		current.prev = null;
		
		head = current;
		
		
		return head;
	}
	
	public static NodeDouble reverseTheList(NodeDouble head){
		
		if (head == null || head.next == null) {
			return head;
		}
		
		NodeDouble current = head;
		NodeDouble temp = null;
		
		// Node1 Node2 Node3
		
		while (current != null){
			// swap prev and next
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			
			// move to "next" node in original list
			current = current.prev;
		}
		
	
		head = temp.prev;
		
		return head;
	}
	
	static void main(String[] args) {
		CustomDoubleLinkedList newList = new CustomDoubleLinkedList();
		
		newList.add(10);
		newList.add(11);
		newList.add(12);
		newList.add(13);
		newList.add(14);
		newList.add(15);
		newList.add(16);
		newList.add(17);
		
		System.out.print("Printing list backward\n");
		printDoubleListBackward(newList.head);
		
		System.out.print("Printing list forward\n");
		printDoubleListForward(newList.head);
		
		System.out.println("Deleting the first node\n");
		newList.head = deleteNodeInDoubleList(newList.head);
		printDoubleListForward(newList.head);
		
		System.out.println("Reversing the list \n");
		newList.head = reverseTheList(newList.head);
		printDoubleListForward(newList.head);
		
	}
}