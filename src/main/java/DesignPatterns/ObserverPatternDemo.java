package DesignPatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {
	
	// Observer
	interface Observer {
		void update(String message);
	}
	
	// Subject
	interface Subject {
		void register(Observer observer);
		void unregister(Observer observer);
		void notifyObservers();
	}
	
	// ConcreteSubject
	static class NotificationService implements Subject {
		
		private final List<Observer> observers = new ArrayList<>();
		private String message;
		
		public void setMessage(String message) {
			this.message = message;
			notifyObservers();
		}
		
		@Override
		public void register(Observer observer) {
			observers.add(observer);
		}
		
		@Override
		public void unregister(Observer observer) {
			observers.remove(observer);
		}
		
		@Override
		public void notifyObservers() {
			for (Observer observer : observers) {
				observer.update(message);
			}
		}
	}
	
	// ConcreteObserver 1
	static class EmailSubscriber implements Observer {
		@Override
		public void update(String message) {
			System.out.println("Email received: " + message);
		}
	}
	
	// ConcreteObserver 2
	static class SmsSubscriber implements Observer {
		@Override
		public void update(String message) {
			System.out.println("SMS received: " + message);
		}
	}
	
	// Client
	public static void main(String[] args) {
		NotificationService service = new NotificationService();
		
		service.register(new EmailSubscriber());
		service.register(new SmsSubscriber());
		
		service.setMessage("Order placed successfully");
	}
}
