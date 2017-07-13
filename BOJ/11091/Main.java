/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11091
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0) {
			int[] pangram = new int[26];
			StringBuilder output = new StringBuilder();
			String sentence = input.nextLine();

			for (int index = 0, size = sentence.length(); index < size; index++) {
				char letter = sentence.charAt(index);
				if ((letter >= 65 && letter <= 90) || (letter >= 97 && letter <= 122))
					pangram[(letter + "").toUpperCase().charAt(0) % 65]++;
			}

			for (int index = 0; index < pangram.length; index++)
				if (pangram[index] == 0)
					output.append((char) (index + 97));

			if (output.toString().equals(""))
				System.out.println("pangram");
			else
				System.out.println("missing " + output.toString());
		}
	}
}