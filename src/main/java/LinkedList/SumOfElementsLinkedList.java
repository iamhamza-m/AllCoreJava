package LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SumOfElementsLinkedList {
	
	
	//Recursive method but removing the first
	static int summation (LinkedList<Integer> nodeElement, int sum){
		if(!nodeElement.iterator().hasNext()){
			return sum;
		}
		
		sum = sum + nodeElement.getFirst();
		nodeElement.removeFirst();
		
		return summation(nodeElement, sum);
		
	}
	
	//For loop method
	static int summationLoop(LinkedList<Integer> list){
		int sum = 0;
		for (Integer integer : list) {
			sum = sum + integer;
		}
		return sum;
	}
	
	
	//Recursive using iterator
	static  int summationIterator(Iterator<Integer> it, int sum){
		if(!it.hasNext()){
			return sum;
		}
		
		return summationIterator(it, sum + it.next());
	}
	
	static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(2, 100);
		list.addFirst(200);
		list.addLast(300);
		
		Iterator<Integer> it = list.iterator();
		
		System.out.println("Sum using pure recursion: "+ summationIterator(it, 0));
		
		System.out.println("Sum using for loop: "+ summationLoop(list));
		
		int sumAll = summation(list,0);
		
		System.out.println("Sum using recursion with removal: " + sumAll);
	}
}
