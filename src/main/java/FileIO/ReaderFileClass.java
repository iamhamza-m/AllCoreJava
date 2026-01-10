package FileIO;

import java.io.FileReader;
import java.io.IOException;

/**
 * Reads and prints content from a file character by character.
 */
public class ReaderFileClass {
	public static void main(String[] args) {
		try (FileReader reader = new FileReader("File.txt")) {
			int read = 0;
			do {
				read = reader.read();
				System.out.print((char) read);
			} while (read != -1);
			
		} catch (IOException exception) {
			System.out.printf("An error occurred, %s", exception.getMessage());
		}
	}
}
