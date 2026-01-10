package ThreadingChallenge;

/**
 * Thread for simulating traffic light colors.
 */
public class TrafficLightThread extends Thread {
	
	private final TrafficLightsColorTie color;
	
	
	public TrafficLightThread(TrafficLightsColorTie color) {
		this.color = color;
	}
	
	@Override
	public void run() {
		System.out.printf("%s : light is active, %s\n", color, color.getMessage());
		try {
			Thread.sleep(color.getTimeInMilliSeconds());
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.printf("%s : light is inactive %s\n", color, color.getPaleState());
	}
}
