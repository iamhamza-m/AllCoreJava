package Executors;

/**
 * Simple class to print a string multiple times.
 */
public class NormalClass {
	public String strReceived;
	
	public void printIt(String str) {
		for (int i = 0; i < 100; i++) {
			System.out.printf("%s ", str);
		}
		System.out.println();
	}
	
	public NormalClass(String strReceived) {
		this.strReceived = strReceived;
		printIt(this.strReceived);
	}
	
}
