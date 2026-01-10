package Interviews;

/**
 * Demonstrates synchronized data sharing between threads.
 */
class Shared {
	private int value = 0;
	
	synchronized void write(int v) {
		value = v;
	}
	
	synchronized int read() {
		return value;
	}
}

public class DataSharingThreads {
	public static void main(String[] args) throws InterruptedException {
		Shared s = new Shared();
		Thread t1 = new Thread(() -> s.write(10));
		Thread t2 = new Thread(() -> System.out.println(s.read()));
		Thread t3 = new Thread(() -> s.write(100));
		Thread t4 = new Thread(() -> System.out.println(s.read()));
		
		t1.start();
		t1.join();
		t2.start();
		t3.start();
		t4.start();
		
	}
}
