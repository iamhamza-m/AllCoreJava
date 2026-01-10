package OOP;

/**
 * Demonstrates static nested class and interface implementation.
 */
public class StaticClass implements InterfacesPractice {
	int instanceVar = 10;
	int staticVar = 20;
	private int length;
	
	
	@Override
	public void getSetGo() {
		System.out.println("Vrooom");
	}
	
	private static class Nested implements InterfacesPractice {
		@Override
		public void getSetGo() {
			System.out.println("Vrooom2");
		}
		
		void show(StaticClass obj) {
			System.out.println("Outer instanceVar: " + obj.instanceVar);
			System.out.println("Outer staticVar: " + obj.staticVar);
			getSetGo();
			obj.getSetGo();
		}
		
		
	}
	
	public static void main(String[] args) {
		StaticClass outer = new StaticClass();
		StaticClass.Nested nested = new StaticClass.Nested();
		outer.getSetGo();
		nested.show(outer);
	}
}

interface InterfacesPractice {
	int number = 0;
	
	void getSetGo();
}
