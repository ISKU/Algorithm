/*
 * Author: Minho Kim (ISKU)
 * Date: January 23, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1919
 */

import java.util.*;

public class Main {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int[] first = new int[26];
		int[] second = new int[26];

		for (char c : sc.next().toCharArray())
			first[c % 97]++;
		for (char c : sc.next().toCharArray())
			second[c % 97]++;

		int count = 0;
		for (int i = 0; i < 26; i++)
			count += Math.abs(first[i] - second[i]);

		System.out.println(count);
	}
}