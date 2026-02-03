package DesignPatterns;

public class SingletonAndBreakingIt {
	private static SingletonAndBreakingIt instance;
	
	private SingletonAndBreakingIt(){
		System.out.println("New instance has been created");
	}
	
	public static SingletonAndBreakingIt getNewInstance(){
		if(instance == null){
			instance = new SingletonAndBreakingIt();
		}
		
		return instance;
	}
}

class SingletonAndBreakingMain {
	static void main(String[] args) {
	
	}
}
