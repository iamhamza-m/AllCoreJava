package DesignPatterns;

/**
 * Implements Singleton pattern: Ensures only one instance of the class.
 * This method is kept public because it will be called to initialize the object from outside the class.
 */
public class SingletonPattern {
	private static SingletonPattern instance;
	private static final Object lock = new Object();
	
	private SingletonPattern() {
		System.out.println("The instance has been created");
	}
	
	public static SingletonPattern getInstance() {
		if (instance == null) {
			synchronized (lock){
				instance = new SingletonPattern();
			}
		}
		
		return instance;
	}
}

class main {
	public static void main(String[] args) {
		SingletonPattern s1 = SingletonPattern.getInstance();
		SingletonPattern s2 = SingletonPattern.getInstance();
		SingletonPattern s3 = SingletonPattern.getInstance();
		
		System.out.println(s1 == s2);
		
	}
}
