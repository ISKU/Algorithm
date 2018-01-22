/*
 * Author: Minho Kim (ISKU)
 * Date: January 21, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1371
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int[] freq = new int[26];

		while (sc.hasNextLine()) {
			for (char c : sc.nextLine().toCharArray()) {
				if (c == ' ')
					continue;
				freq[c % 97]++;
			}
		}

		int max = 0;
		for (int i = 0; i < 26; i++)
			max = Math.max(max, freq[i]);

		for (int i = 0; i < 26; i++)
			if (freq[i] == max)
				System.out.print((char) (i + 97));
	}
}