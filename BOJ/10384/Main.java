/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.09.25
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10384
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		int testCase = Integer.parseInt(input.nextLine());

		for (int test = 1; test <= testCase; test++) {
			int[] pangram = new int[26];
			StringBuilder check = new StringBuilder();
			String sentence = input.nextLine();

			for (int index = 0, size = sentence.length(); index < size; index++) {
				char letter = sentence.charAt(index);
				if ((letter >= 65 && letter <= 90) || (letter >= 97 && letter <= 122))
					pangram[(letter + "").toUpperCase().charAt(0) % 65]++;
			}

			if (checkPangram(pangram, 3))
				output.append("Case " + test + ": Triple pangram!!!\n");
			else if (checkPangram(pangram, 2))
				output.append("Case " + test + ": Double pangram!!\n");
			else if (checkPangram(pangram, 1))
				output.append("Case " + test + ": Pangram!\n");
			else
				output.append("Case " + test + ": Not a pangram\n");
		}

		System.out.print(output);
	}

	private static boolean checkPangram(int[] pangram, int state) {
		for (int index = 0; index < pangram.length; index++)
			if (pangram[index] < state)
				return false;
		return true;
	}
}