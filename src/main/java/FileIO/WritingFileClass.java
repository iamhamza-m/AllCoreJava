package FileIO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Writes content to a file, appending if exists.
 */
public class WritingFileClass {
	public static void main(String[] args) {
		try (FileWriter writer = new FileWriter("File.txt", true)) {
			writer.write("Hello I am file writer");
			for (int i = 0; i < 10000; i++) {
				writer.write("*\n");
			}
			writer.flush();
		} catch (IOException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
