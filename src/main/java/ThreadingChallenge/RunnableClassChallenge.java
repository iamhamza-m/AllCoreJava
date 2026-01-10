package ThreadingChallenge;

/**
 * Runnable for printing hello from thread.
 */
public class RunnableClassChallenge implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.printf("Hello from Thread %s with state %s\n", getThreadName(), Thread.currentThread().getState());
		}
		System.out.printf("-----------------------------Task has been completed by %s-----------------------------\n", Thread.currentThread().getName());
	}
	
	public RunnableClassChallenge() {
	
	}
	
	public String getThreadName() {
		return Thread.currentThread().getName();
	}
}
