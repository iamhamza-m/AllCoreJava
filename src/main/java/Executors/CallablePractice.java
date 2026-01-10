package Executors;

import java.util.concurrent.Callable;

/**
 * Callable task that returns a string after sleep.
 */
public class CallablePractice implements Callable<String> {
	private final String name;
	
	public CallablePractice(String name) {
		this.name = name;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(2000);
		return name + "Student";
	}
	
}
