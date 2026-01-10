package Streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates ways to initialize streams.
 */
public class StreamInit {
	public static void main(String[] args) {
		System.out.println("\n<Stream generated from collection> \n //********************// \n");
		List<String> alphalist = Arrays.asList("a", "b", "b");
		Stream<String> alphaStream = alphalist.stream();
		alphaStream.forEach(System.out::println);
		
		System.out.println("\n<Stream generated from array> \n //********************// \n");
		String[] alphaArray = {"a", "b", "c"};
		Stream<String> alphaStreamArray = Arrays.stream(alphaArray);
		alphaStreamArray.forEach(System.out::println);
		
		System.out.println("\n<Stream generated from Stream.of> \n //********************// \n");
		Stream<String> alphaStreamOf = Stream.of("a", "b", "c");
		alphaStreamOf.forEach(System.out::println);
		
		System.out.println("\n<Stream generated from Stream.builder> \n //********************// \n");
		Stream.Builder<String> builder = Stream.builder();
		builder.add("a").add("b").add("c");
		Stream<String> alphaStreamBuilder = builder.build();
		alphaStreamBuilder.forEach(System.out::println);
		
		System.out.println("\n<Stream generated from Stream.generate> \n //********************// \n");
		Stream<String> alphaStreamGenerate = Stream.generate(() -> "a").limit(5);
		alphaStreamGenerate.forEach(System.out::println);
		
		System.out.println("\n<Stream generated from Stream.iterate> \n //********************// \n");
		Stream<Integer> alphaStreamIterate = Stream.iterate(1, x -> x + 1).limit(5);
		alphaStreamIterate.forEach(System.out::println);
		
		System.out.println("\n<Stream generated from String.chars> \n //********************// \n");
		String str = "abc";
		str.chars().mapToObj(c -> (char) c).forEach(System.out::println);
		
		// Example: Find first non-repeating character
		String input = "ababcde";
		Map<Character, Integer> countLetters = new LinkedHashMap<>();
		input.chars().mapToObj(c -> (char) c)
				.forEach(x -> countLetters.put(x, countLetters.getOrDefault(x, 0) + 1));
		
		countLetters.entrySet()
				.stream()
				.filter(entry -> entry.getValue() == 1)
				.findFirst()
				.ifPresent(x -> System.out.println(x.getKey()));
	}
}
