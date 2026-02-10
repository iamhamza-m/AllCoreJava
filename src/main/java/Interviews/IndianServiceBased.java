package Interviews;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IndianServiceBased {
	public static void main(String[] args) {
		
		List<Integer> inputList = Arrays.asList(1,2,2,3,3,3,4,5,6,7);
		
		inputList.stream()
				.collect(Collectors.groupingBy(
						Integer::intValue,
						Collectors.counting()
				))
				.entrySet()
				.stream()
				.filter(entry -> entry.getValue() > 1)
				.flatMap(entry ->
								 IntStream.range(1, entry.getValue().intValue())
										 .mapToObj(i -> entry.getKey())
				)
				.forEach(System.out::println);
	}
}
