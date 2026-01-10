package DesignPatterns;

/**
 * Demonstrates State pattern: Allows an object to alter its behavior when its internal state changes.
 */
interface State {
	void handle(Context context);
}

class PlayingState implements State {
	public void handle(Context context) {
		System.out.println("Playing");
		context.setState(new PausedState());
	}
}

class PausedState implements State {
	public void handle(Context context) {
		System.out.println("Paused");
		context.setState(new PlayingState());
	}
}

class Context {
	private State state;
	
	public Context(State state) {
		this.state = state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void request() {
		state.handle(this);
	}
}

public class StatePattern {
	public static void main(String[] args) {
		
		Context player = new Context(new PlayingState());
		player.request();
		player.request();
	}
}
