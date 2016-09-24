/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5704
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();

		while (true) {
			int[] pangram = new int[26];
			StringBuilder check = new StringBuilder();
			String sentence = input.nextLine();

			if (sentence.equals("*"))
				break;

			for (int index = 0, size = sentence.length(); index < size; index++) {
				char letter = sentence.charAt(index);
				if (letter >= 97 && letter <= 122)
					pangram[(letter + "").toUpperCase().charAt(0) % 65]++;
			}

			for (int index = 0; index < pangram.length; index++)
				if (pangram[index] == 0)
					check.append((char) (index + 97));

			output.append((check.toString().equals("")) ? "Y\n" : "N\n");
		}

		System.out.print(output);
	}
}