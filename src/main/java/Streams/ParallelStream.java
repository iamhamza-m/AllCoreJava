package Streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates parallel streams for performance.
 */
public class ParallelStream {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		List<Integer> list = Stream.iterate(1, x -> x + 1).limit(2000).collect(Collectors.toList());
		List<Long> factorialList = list.stream().map(ParallelStream::factorial).toList();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Total time taken in sequential stream " + (endTime - startTime) + " ms");
		
		
		long startTimeParallel = System.currentTimeMillis();
		
		factorialList = list.parallelStream().map(ParallelStream::factorial).sequential().toList();
		
		long endTimeParallel = System.currentTimeMillis();
		
		System.out.println("Total time taken in parallel stream " + (endTimeParallel - startTimeParallel) + " ms");
	}
	
	private static long factorial(int n) {
		long result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
