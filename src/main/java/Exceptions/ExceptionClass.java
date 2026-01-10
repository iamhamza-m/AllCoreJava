package Exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Demonstrates exception handling for arithmetic and IO operations.
 */
public class ExceptionClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two numbers");
		int first = input.nextInt();
		int second = input.nextInt();
		try {
			int result = first / second;
			System.out.printf("Result is : %d", result);
		} catch (ArithmeticException exception) {
			System.out.printf("%s, Enter a valid value", exception.getMessage());
		}
		
		ExceptionClass obj = new ExceptionClass();
		try {
			obj.readFile();
		} catch (IOException e) {
			System.out.println("File not found: " + e.getMessage());
		}
		
	}
	
	public void readFile() throws IOException {
		FileReader fr = new FileReader("test.txt"); // might throw IOException
		BufferedReader br = new BufferedReader(fr);
		System.out.println(br.readLine());
	}
}
