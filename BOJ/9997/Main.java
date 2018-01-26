/*
 * Author: Minho Kim (ISKU)
 * Date: January 27, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9997
 */

import java.util.*;

public class Main {

	private static int N, count;
	private static int[] word;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		word = new int[N];
		for (int i = 0; i < N; i++)
			for (char c : sc.next().toCharArray())
				word[i] |= 1 << (c % 97);

		dfs(0, 0);
		System.out.print(count);
	}

	private static void dfs(int i, int letter) {
		if (i == N) {
			if (letter == 67108863)
				count++;
			return;
		}

		dfs(i + 1, letter | word[i]);
		dfs(i + 1, letter);
	}
}