package ThreadingChallenge;

/**
 * Runs RunnableClassChallenge threads with join.
 */
public class RunnableClassImplementation {
	public static void main(String[] args) throws InterruptedException {
		RunnableClassChallenge process = new RunnableClassChallenge();
		Thread T1 = new Thread(process);
		Thread T2 = new Thread(process);
		T1.start();
		T1.join();
		T2.start();
	}
}
