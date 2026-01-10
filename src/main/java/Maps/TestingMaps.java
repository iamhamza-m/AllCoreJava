package Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Tests HashMap operations with custom class.
 */
public class TestingMaps {
	
	
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("Apple", 10);
		map.put("Oranges", 20);
		map.put("Mangoes", 20);
		map.put("Guvava", 45);
		
		System.out.println(map.size());
		System.out.println(map.get("Oranges"));
		System.out.println(map.containsKey("Guvava"));
		System.out.println(map.containsValue(45));
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	
	private static class Fruits {
		String name;
		int weight;
		
		public Fruits(String name, int weight) {
			this.name = name;
			this.weight = weight;
		}
		
		public String getName() {
			return name;
		}
		
		public int getWeight() {
			return weight;
		}
		
		@Override
		public String toString() {
			return "Fruits{" +
						   "name='" + name + '\'' +
						   ", weight=" + weight +
						   '}';
		}
	}
}
