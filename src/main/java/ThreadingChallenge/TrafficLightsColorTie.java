package ThreadingChallenge;

/**
 * Enum for traffic light colors with times.
 */
public enum TrafficLightsColorTie {
	RED(9000, "Stop", ""), YELLOW(5000, "Wait", ""), GREEN(15000, "Go !", "");
	
	
	private final int timeInMilliSeconds;
	private final String message;
	private final String paleState;
	
	TrafficLightsColorTie(int timeInMilliSeconds, String message, String paleState) {
		this.timeInMilliSeconds = timeInMilliSeconds;
		this.message = message;
		this.paleState = paleState;
	}
	
	public int getTimeInMilliSeconds() {
		return timeInMilliSeconds;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getPaleState() {
		return paleState;
	}
}
