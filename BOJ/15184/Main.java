/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.23
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15184
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		char[] line = new Scanner(System.in).nextLine().toUpperCase().toCharArray();
		int[] letter = new int[26];

		for (char c : line)
			if (c >= 65 && c <= 90)
				letter[c - 65]++;

		for (int i = 0; i < 26; i++) {
			System.out.printf("%c | ", (char) (i + 65));
			for (int j = 0; j < letter[i]; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}