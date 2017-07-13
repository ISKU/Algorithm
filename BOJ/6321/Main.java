/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6321
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int testCase = input.nextInt();

		for (int test = 1; test <= testCase; test++) {
			StringBuilder newWord = new StringBuilder("String #" + test + "\n");
			String word = input.next();

			for (int index = 0, size = word.length(); index < size; index++) {
				char letter = (char) (word.charAt(index) + 1);
				newWord.append((letter < 91) ? letter : 'A');
			}
			output.append(newWord + "\n\n");
		}

		System.out.print(output);
	}
}