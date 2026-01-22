package DesignPatterns;

/**
 * Demonstrates Factory pattern: Creates objects without specifying the exact class.
 */

interface Carz {
	void drive();
}

class Sedan implements Carz {
	public void drive() {
		System.out.println("This car is a sedan");
	}
}

class Suv implements Carz {
	public void drive() {
		System.out.println("This car is an suv");
	}
}

class CarFactory {
	public static Carz carFactoryMethod(String type) {
		if ("sedan".equalsIgnoreCase(type)) return new Sedan();
		if ("suv".equalsIgnoreCase(type)) return new Suv();
		throw new IllegalArgumentException("Unknown type");
	}
}

public class FactoryDesign {
	public static void main(String[] args) {
		Carz car = CarFactory.carFactoryMethod("sedan");
		car.drive();
	}
}
