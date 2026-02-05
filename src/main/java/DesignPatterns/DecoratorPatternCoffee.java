package DesignPatterns;

public class DecoratorPatternCoffee {
	// 1. Component interface
	interface Coffee {
		String getDescription();
		int getPrice();
	}
	
	// 2. Concrete component
	static class SimpleCoffee implements Coffee {
		
		@Override
		public String getDescription() {
			return "Simple Coffee";
		}
		
		@Override
		public int getPrice() {
			return 50;
		}
	}
	
	// 3. Abstract decorator
	static abstract class CoffeeContext implements Coffee {
		
		public Coffee coffee;
		
		public CoffeeContext(Coffee coffee) {
			this.coffee = coffee;
		}
		
		@Override
		public String getDescription() {
			return coffee.getDescription();
		}
		
		@Override
		public int getPrice() {
			return coffee.getPrice();
		}
	}
	
	// 4. Concrete decorator - Milk
	static class MilkCoffee extends CoffeeContext {
		
		public MilkCoffee(Coffee coffee) {
			super(coffee);
		}
		
		@Override
		public String getDescription() {
			return super.getDescription() + ", Milk";
		}
		
		@Override
		public int getPrice() {
			return super.getPrice() + 20;
		}
	}
	
	// 5. Concrete decorator - Sugar
	static class SugarCoffee extends CoffeeContext {
		
		public SugarCoffee(Coffee coffee) {
			super(coffee);
		}
		
		@Override
		public String getDescription() {
			return super.getDescription() + ", Sugar";
		}
		
		@Override
		public int getPrice() {
			return super.getPrice() + 10;
		}
	}
	
	// 6. Main method
	public static void main(String[] args) {
		
		Coffee coffee = new SimpleCoffee();
		System.out.println(coffee.getDescription() + " -> ₹" + coffee.getPrice());
		
		coffee = new MilkCoffee(coffee);
		System.out.println(coffee.getDescription() + " -> ₹" + coffee.getPrice());
		
		coffee = new SugarCoffee(coffee);
		System.out.println(coffee.getDescription() + " -> ₹" + coffee.getPrice());
	}
}
