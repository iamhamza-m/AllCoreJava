package DesignPatterns;

/**
 * Demonstrates Composition: Car has an Engine.
 */
public class Engine {
	void start() {
		System.out.println("Engine started");
	}
}

class Car {
	private Engine engine;
	
	Car(Engine engine) {
		this.engine = engine;
	}
	
	void drive() {
		engine.start();
		System.out.println("Car driving");
	}
}

class mainEngine {
	public static void main(String[] args) {
		Car maruti = new Car(new Engine());
		maruti.drive();
	}
}
