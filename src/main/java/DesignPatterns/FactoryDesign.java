package DesignPatterns;

/**
 * Demonstrates Factory pattern: Creates objects without specifying the exact class.
 */
interface car {
	void drive();
}

class sedan implements car {
	@Override
	public void drive() {
		System.out.println("This car is a sedan");
	}
}

class suv implements car {
	@Override
	public void drive() {
		System.out.println("This car is an suv");
	}
}

class carfactory {
	
	public static car carFactoryMethod(String type) {
		if ("Sedan".equalsIgnoreCase(type))
			return new sedan();
		else if ("Suv".equalsIgnoreCase(type))
			return new suv();
		
		else
			throw new IllegalArgumentException("Unknown type");
	}
}

public class FactoryDesign {
	public static void main(String[] args) {
		car car = carfactory.carFactoryMethod("sedan");
		car.drive();
	}
}
