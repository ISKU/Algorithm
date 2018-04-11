/*
 * Author: Minho Kim (ISKU)
 * Date: April 10, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/962/C
 */

import java.util.*;

public class C {

	private static HashSet<Integer> square;
	private static int[] N;
	private static int SIZE, answer;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		SIZE = String.valueOf(number).length();

		square = new HashSet<>();
		for (int i = 1; i * i <= 2e9; i++)
			square.add(i * i);

		N = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			N[i] = number % 10;
			number /= 10;
		}

		answer = Integer.MAX_VALUE;
		dfs(0, 1, 0);
		System.out.print((answer == Integer.MAX_VALUE) ? -1 : answer);
	}

	private static void dfs(int i, int d, int value) {
		if (square.contains(value))
			answer = Math.min(answer, SIZE - String.valueOf(value).length());
		if (i >= SIZE)
			return;

		dfs(i + 1, d * 10, N[i] * d + value);
		dfs(i + 1, d, value);
	}
}