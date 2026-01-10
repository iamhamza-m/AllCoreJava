package DesignPatterns;

/**
 * Thread-safe Singleton using double-checked locking.
 */
public class ThreadsafeSingleton {
	
	private static volatile ThreadsafeSingleton instance;
	
	private ThreadsafeSingleton() {
		System.out.println("Instance has been allocated");
	}
	
	public static ThreadsafeSingleton getInstance() {
		if (instance == null) {                  // 1st check
			synchronized (ThreadsafeSingleton.class) {
				if (instance == null) {          // 2nd check
					instance = new ThreadsafeSingleton();
				}
			}
		}
		return instance;
	}
}

class mainThreadsafeSingleton {
	public static void main(String[] args) {
		ThreadsafeSingleton s1 = ThreadsafeSingleton.getInstance();
		ThreadsafeSingleton s2 = ThreadsafeSingleton.getInstance();
		
		System.out.println(s1 == s2);
		
	}
}
