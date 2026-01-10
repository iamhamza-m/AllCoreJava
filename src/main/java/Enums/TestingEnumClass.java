package Enums;

/**
 * Tests enum values and methods.
 */
public class TestingEnumClass {
	public static void main(String[] args) {
		TestingEnum colors = TestingEnum.valueOf("RED");
		System.out.println(colors.getAction());
		
		for (TestingEnum value : colors.values()) {
			System.out.println(value);
		}
	}
}
