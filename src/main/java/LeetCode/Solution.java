package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * LeetCode solution for counting bits in numbers from 0 to n.
 */
class Solution {
	public static int[] countBits(int n) {
		int[] answer = new int[n + 1];
		
		Map<Integer, List<Integer>> map = new TreeMap<>();
		
		int[] result = map.values().stream().flatMap(List::stream).mapToInt(Integer::intValue).toArray();
		
		for (int i = 0; i <= n; i++) {
			int num = i;
			int count = 0;
			
			while (num != 0) {
				count += (num & 1);
				num = num >> 1;
			}
			
			answer[i] = count;
		}
		
		return answer;
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(2)));
	}
}
