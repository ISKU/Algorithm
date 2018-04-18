/*
 * Author: Minho Kim (ISKU)
 * Date: April 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15658
 */

import java.util.*;

public class Main {

	private static int N, MIN, MAX;
	private static int[] array, operator;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = sc.nextInt();

		operator = new int[4];
		for (int i = 0; i < 4; i++)
			operator[i] = sc.nextInt();

		MIN = Integer.MAX_VALUE;
		MAX = Integer.MIN_VALUE;
		dfs(1, array[0]);

		System.out.printf("%d\n%d", MAX, MIN);
	}

	private static void dfs(int n, int result) {
		if (n == N) {
			MAX = Math.max(MAX, result);
			MIN = Math.min(MIN, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				int sum = result;

				if (i == 0)
					sum += array[n];
				else if (i == 1)
					sum -= array[n];
				else if (i == 2)
					sum *= array[n];
				else if (i == 3)
					sum /= array[n];

				operator[i]--;
				dfs(n + 1, sum);
				operator[i]++;
			}
		}
	}
}