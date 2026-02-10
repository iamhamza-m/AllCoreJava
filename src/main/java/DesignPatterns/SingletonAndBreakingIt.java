package DesignPatterns;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonAndBreakingIt implements Serializable, Cloneable {
	//Thread safety - Adding volatile
	private static volatile SingletonAndBreakingIt instance;
	
	private SingletonAndBreakingIt(){
		//Reflection safety
//		if(instance != null){
//			throw new IllegalArgumentException("You are trying to break Singleton pattern.");
//		}
		System.out.println("New instance has been created");
	}
	
	public static SingletonAndBreakingIt getNewInstance(){
		if(instance == null){
			//Thread safety
			synchronized (SingletonAndBreakingIt.class){
				if(instance == null){
					instance = new SingletonAndBreakingIt();
				}
			}
		}
		
		return instance;
	}
	
	public void drive(){
		System.out.println("We are driving the car");
	}
	
	//Serialization safety
	@Serial
	private Object readResolve() {
		return getNewInstance();
	}
	
	//Clone Safety
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("You cannot break Singleton method. Cloning stopped.");
	}
}

class SingletonAndBreakingMain {
	static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
		
		//Thread Attack.
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				SingletonAndBreakingIt object = SingletonAndBreakingIt.getNewInstance();
				System.out.println(object.hashCode());
			}
		};

		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		Thread t3 = new Thread(runnable);

		t1.start();
		t2.start();
		t3.start();

		try{
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		//Reflection Attack.
		Constructor<SingletonAndBreakingIt> breakingItConstructor = SingletonAndBreakingIt.class.getDeclaredConstructor();
		breakingItConstructor.setAccessible(true);
		SingletonAndBreakingIt breakingInstance = breakingItConstructor.newInstance();
		System.out.println(breakingInstance.hashCode());
		
		
		//Serializing and Deserializing Attack.
		SingletonAndBreakingIt serInstance = SingletonAndBreakingIt.getNewInstance();
		
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("SingletonBreaking.json"));
		outputStream.writeObject(serInstance);
		outputStream.close();
		
		System.out.println(serInstance.hashCode());
		
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("SingletonBreaking.json"));
		SingletonAndBreakingIt serInstanceNew = (SingletonAndBreakingIt) inputStream.readObject();
		inputStream.close();
		
		System.out.println(serInstanceNew.hashCode());
		
		//Clone Attack.
		
		SingletonAndBreakingIt cloneInstance = SingletonAndBreakingIt.getNewInstance();
		
		try {
			SingletonAndBreakingIt cloneInstanceSecond = (SingletonAndBreakingIt) cloneInstance.clone();
			System.out.println(cloneInstanceSecond.hashCode());
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
		
	}
}
