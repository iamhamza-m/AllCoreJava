package DesignPatterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstrates thread pool using ExecutorService.
 */
class ThreadPoolExample {
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++) {
			pool.execute(() -> System.out.println(Thread.currentThread().getName() + " running"));
		}
		pool.shutdown();
	}
}
