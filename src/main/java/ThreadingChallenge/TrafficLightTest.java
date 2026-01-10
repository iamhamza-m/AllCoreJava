package ThreadingChallenge;

import java.time.LocalTime;

/**
 * Tests traffic light simulation until a time.
 */
public class TrafficLightTest {
	public static void main(String[] args) throws InterruptedException {
		do {
			TrafficLightThread green = new TrafficLightThread(TrafficLightsColorTie.GREEN);
			green.start();
			green.join();
			TrafficLightThread yellow = new TrafficLightThread(TrafficLightsColorTie.YELLOW);
			yellow.start();
			yellow.join();
			TrafficLightThread red = new TrafficLightThread(TrafficLightsColorTie.RED);
			red.start();
			red.join();
		} while (LocalTime.now().isBefore(LocalTime.of(9, 0)));
	}
}
