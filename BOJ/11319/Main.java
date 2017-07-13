/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.02.14
 * Email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11319
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		Scanner input = new Scanner(System.in);
		int testCase = Integer.parseInt(input.nextLine());

		while (testCase-- > 0) {
			String[] sentence = input.nextLine().toLowerCase().replaceAll(" ", "").split("");

			int vowels = 0;
			for (int i = 0; i < sentence.length; i++)
				if (isVowel(sentence[i]))
					vowels++;

			System.out.println(sentence.length - vowels + " " + vowels);
		}
	}

	private static boolean isVowel(String vowel) {
		switch (vowel) {
		case "a":
		case "e":
		case "i":
		case "o":
		case "u":
			return true;
		default:
			return false;
		}
	}
}