package Strings;

/**
 * Reverses a string and checks if palindrome.
 */
public class ReverseAndPalindrome {
	
	public static String reverse(String input) {
		char[] arr = input.toCharArray();
		int i = 0, j = arr.length - 1;
		
		while (i < j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return new String(arr);
	}
	
	public static void main(String[] args) {
		String word = "madam";
		
		String reversed = reverse(word);
		
		System.out.println("Original : " + word);
		System.out.println("Reversed : " + reversed);
		System.out.println("Is Palindrome : " + word.equals(reversed));
	}
}
