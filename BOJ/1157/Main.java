/* 
 * Author: Kim Min-Ho (ISKU)
 * Date: 2017.01.10
 * email: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1157
 */

import java.util.Scanner;

public class Main {
	public static void main(String... args) {
		String word = new Scanner(System.in).nextLine();
		int[] letters = new int[26];

		for (int index = 0, size = word.length(); index < size; index++) {
			char letter = word.charAt(index);
			letters[(letter >= 97) ? letter % 97 : letter % 65]++;
		}

		int maxLetter = 65;
		int max = letters[0];
		for (int index = 1; index < letters.length; index++) {
			if (letters[index] > max) {
				maxLetter = index + 65;
				max = letters[index];
			}
		}

		boolean check = false;
		for (int index = 0; index < letters.length; index++) {
			if (index != (maxLetter % 65) && max == letters[index])
				check = true;
		}

		System.out.print(check ? "?" : (char) maxLetter);
	}
}