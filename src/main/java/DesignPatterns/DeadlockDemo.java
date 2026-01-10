package DesignPatterns;

/**
 * Demonstrates a deadlock scenario using two threads and two locks.
 */
class DeadlockDemo {
	
	static final Object lock1 = new Object();
	static final Object lock2 = new Object();
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> {
			synchronized (lock1) {
				System.out.println("Thread-1 got lock1");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					System.out.println("Exception thrown" + e);
				}
				
				synchronized (lock2) {
					System.out.println("Thread-1 got lock2");
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			synchronized (lock2) {
				System.out.println("Thread-2 got lock2");
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					System.out.println("Exception thrown" + e);
				}
				
				synchronized (lock1) {
					System.out.println("Thread-2 got lock1");
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
