package Executors;

import java.util.concurrent.*;

/**
 * Demonstrates ExecutorService with Runnable and Callable tasks.
 */
public class ExecutorClass {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		PrintCharTask task = new PrintCharTask('$');
		PrintCharTask task2 = new PrintCharTask('%');
		PrintCharTask task3 = new PrintCharTask('@');
		service.submit(task);
		service.submit(task2);
		service.submit(task3);
		
		
		// Callable example
		CallablePractice callTask = new CallablePractice("Hamza ");
		Future<String> name1 = service.submit(callTask);
		System.out.println("\n Callable result : " + name1.get());
		service.shutdown();
		if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
			service.shutdownNow();
		}
	}
}
