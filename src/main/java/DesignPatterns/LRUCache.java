package DesignPatterns;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implements LRU Cache using LinkedHashMap with access order.
 */
class LRUCache<K, V> extends LinkedHashMap<K, V> {
	
	private final int capacity;
	
	public LRUCache(int capacity) {
		// true = access-order (LRU), false = insertion-order
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > capacity;
	}
}

class LRUMain {
	public static void main(String[] args) {
		
		LRUCache<Integer, Integer> cache = new LRUCache<>(3);
		
		cache.put(1, 10);
		cache.put(2, 20);
		cache.put(3, 30);
		
		cache.get(1);        // access 1 → becomes most recent
		cache.put(4, 40);   // evicts key 2 (least recently used)
		
		System.out.println(cache); // {3=30, 1=10, 4=40}
	}
}
