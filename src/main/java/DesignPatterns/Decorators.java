package DesignPatterns;

/**
 * Demonstrates Decorator pattern: Adds behavior to an object without affecting its class.
 */
interface Vehicle {
	void drive();
}

class BMW implements Vehicle {
	public void drive() {
		System.out.println("Driving BMW");  // Note: Original says Lamborghini, but class is BMW – possible typo, kept as is
	}
}

class SportBMW implements Vehicle {
	private Vehicle vehicle;
	
	SportBMW(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public void drive() {
		vehicle.drive();  // Delegate to wrapped object
		System.out.println("Sport mode ON"); // Adding new functionalities dynamically.
	}
}

class DecoratorMain {
	public static void main(String[] args) {
		BMW bmw = new BMW();
		Vehicle car = new SportBMW(bmw);
		car.drive();
	}
}
