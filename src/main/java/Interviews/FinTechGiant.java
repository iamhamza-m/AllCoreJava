package Interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class FinTechGiant {
	static void main(String[] args) {
		String s = "Mississippi";
		Map<Character, Integer> frequency = new LinkedHashMap<>();
		
		s.chars()
				.mapToObj(character -> (char) character)
				.forEach(value -> frequency.put(value, frequency.getOrDefault(value, 0) + 1));
		
		frequency.entrySet()
				.stream()
				.filter(entry -> entry.getValue()==1)
				.findFirst()
				.ifPresentOrElse(entry -> System.out.printf("The answer is %c", entry.getKey()),
						() -> System.out.print("The answer is -1"));
	}
}
