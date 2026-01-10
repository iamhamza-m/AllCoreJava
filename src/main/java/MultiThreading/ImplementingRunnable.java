package MultiThreading;

/**
 * Runnable that prints a character with numbers and thread details.
 */
public class ImplementingRunnable implements Runnable {
	
	@Override
	public void run() {
		
		for (int i = 0; i < 1000; i++) {
			System.out.printf("%s: %d", targetChar, i);
		}
		System.out.printf("\n task completed for thread : %s and %d priority ", Thread.currentThread().getName(), Thread.currentThread().getPriority());
	}
	
	private final char targetChar;
	
	public ImplementingRunnable(char targetChar) {
		this.targetChar = targetChar;
	}
	
}
