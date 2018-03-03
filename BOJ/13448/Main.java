/*
 * Author: Minho Kim (ISKU)
 * Date: March 4, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13448
 */

import java.util.*;

public class Main {

	private static Node[] node;
	private static long[][] dp;
	private static int N, T;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = sc.nextInt();

		node = new Node[N];
		for (int i = 0; i < N; i++)
			node[i] = new Node();

		for (int i = 0; i < N; i++)
			node[i].M = sc.nextInt();
		for (int i = 0; i < N; i++)
			node[i].P = sc.nextInt();
		for (int i = 0; i < N; i++)
			node[i].R = sc.nextInt();
		for (int i = 0; i < N; i++)
			node[i].priority = (double) node[i].R / node[i].P;

		Arrays.sort(node);
		dp = new long[N][T + 1];
		for (int i = 0; i < N; i++)
			Arrays.fill(dp[i], -1);

		System.out.print(dfs(0, 0));
	}

	private static long dfs(int i, int t) {
		if (i == N)
			return 0;
		if (dp[i][t] != -1)
			return dp[i][t];

		int time = t + node[i].R;
		return dp[i][t] = Math.max(((time > T) ? 0 : dfs(i + 1, time) + score(i, t)), dfs(i + 1, t));
	}

	private static long score(int i, int t) {
		return node[i].M - ((t + node[i].R) * (long) node[i].P);
	}

	private static class Node implements Comparable<Node> {
		public int M, P, R;
		public double priority;

		@Override
		public int compareTo(Node o) {
			if (this.priority < o.priority)
				return -1;
			else if (this.priority > o.priority)
				return 1;
			else
				return 0;
		}
	}
}