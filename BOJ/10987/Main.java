/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2016.08.02
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10987
 */

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String[] word = input.next().split("");
		int numberOfVowels = 0;

		for (int character = 0; character < word.length; character++)
			if (checkVowel(word[character]))
				numberOfVowels++;

		System.out.println(numberOfVowels);
	}

	private static Boolean checkVowel(String vowel) {
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