package LinkedList;

import java.util.LinkedList;
import java.util.List;

public class SumOfElementsLinkedList {
	
	
	//Recursive method
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
	
	static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		
		System.out.println("Sum using for loop: "+ summationLoop(list));
		
		int sumAll = summation(list,0);
		
		System.out.println("Sum using recursion: " + sumAll);
		
		
		
	}
}
