package Enums;

/**
 * Enum with constructor and method.
 */
enum TestingEnum {
	RED("RedColor"), BLUE("BlueColor"), GREEN("GreenColor");
	private final String action;
	
	public String getAction() {
		return action;
	}
	
	TestingEnum(String action) {
		this.action = action;
	}
}
