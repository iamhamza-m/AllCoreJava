package Executors;

/**
 * Runnable task to print a character multiple times, synchronized.
 */
public class PrintCharTask implements Runnable {
	private static final Object LOCK = new Object();
	char targetChar;
	
	@Override
	public void run() {
		synchronized (LOCK) {
			System.out.println();
			for (int i = 0; i <= 10; i++) {
				System.out.printf("%c", targetChar);
			}
			printTheThreadDetails();
		}
	}
	
	public void printTheThreadDetails() {
		System.out.printf("\n Thread name is %s and parentCharacter is %c ", Thread.currentThread().getName(), targetChar);
	}
	
	public PrintCharTask(char targetChar) {
		this.targetChar = targetChar;
	}
	
}
