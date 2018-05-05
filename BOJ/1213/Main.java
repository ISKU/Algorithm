/*
 * Author: Minho Kim (ISKU)
 * Date: May 5, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1213
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		char[] name = new Scanner(System.in).next().toCharArray();

		int[] letter = new int[26];
		for (char c : name)
			letter[c - 'A']++;

		int count = 0;
		String mid = "";
		for (int i = 0; i < 26; i++) {
			if (letter[i] % 2 == 1) {
				count++;
				letter[i]--;
				mid = String.valueOf((char) (i + 'A'));
			}
		}

		if (count >= 2) {
			System.out.print("I'm Sorry Hansoo");
			System.exit(0);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++)
			for (int j = letter[i] / 2; j > 0; j--)
				sb.append((char) (i + 'A'));

		System.out.print(sb.toString() + mid + sb.reverse().toString());
	}
}