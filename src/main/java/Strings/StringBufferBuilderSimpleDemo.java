package Strings;

/**
 * Simple demo of StringBuffer and StringBuilder methods.
 */
public class StringBufferBuilderSimpleDemo {
	public static void main(String[] args) {
		// StringBuffer Example (Thread-safe)
		StringBuffer buffer = new StringBuffer("Hello");
		buffer.append(" World");
		buffer.insert(5, ",");
		System.out.println("StringBuffer: " + buffer.toString());
		
		// StringBuilder Example (Not thread-safe, faster)
		StringBuilder builder = new StringBuilder("Hello");
		builder.append(" World");
		builder.insert(5, ",");
		System.out.println("StringBuilder: " + builder.toString());
		
		System.out.println("Reversed Builder: " + builder.reverse());
		
		// Reset for more examples
		buffer.reverse();
		builder.reverse();
		
		// Additional common methods
		System.out.println("\nAdditional methods:");
		System.out.println("Buffer length: " + buffer.length());
		System.out.println("Builder capacity: " + builder.capacity());
		System.out.println("Buffer char at 0: " + buffer.charAt(0));
		
		// Delete examples
		buffer.delete(5, 7);
		builder.delete(5, 7);
		System.out.println("After delete: " + buffer.toString());
	}
}
