package Strings;

/**
 * Basic StringBuilder usage.
 */
public class StringBuilderClass {
	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder("Initially");
		stringBuilder.append(" , this string only had \" Initially \" word.");
		stringBuilder.append(" After sometime more words were added");
		System.out.println(stringBuilder);
	}
}
