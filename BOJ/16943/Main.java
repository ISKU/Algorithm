/*
 * Author: Minho Kim (ISKU)
 * Date: February 19, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16943
 */

import java.util.*;

public class Main {

	private static int[] digit;
	private static boolean[] visited;
	private static int N;
	private static long B, answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] A = sc.next().toCharArray();
		B = sc.nextLong();

		N = A.length;
		digit = new int[N];
		for (int i = 0; i < N; i++)
			digit[i] = A[i] - '0';

		visited = new boolean[N];
		answer = -1;
		dfs(0, 0);
		System.out.println(answer);
	}

	private static void dfs(int n, long candidate) {
		if (n == N) {
			if (candidate <= B)
				answer = Math.max(answer, candidate);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			if (digit[i] == 0 && candidate == 0)
				continue;

			visited[i] = true;
			dfs(n + 1, candidate * 10 + digit[i]);
			visited[i] = false;
		}
	}
}