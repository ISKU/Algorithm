/*
 * Author: Minho Kim (ISKU)
 * Date: May 4, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17182
 */

import java.io.*;
import java.util.*;

public class Main {

	private static int[][] dist;
	private static boolean[] visited;
	private static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				dist[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int k = 0; k < N; k++)
			for (int u = 0; u < N; u++)
				for (int v = 0; v < N; v++)
					dist[u][v] = Math.min(dist[u][v], dist[u][k] + dist[k][v]);

		visited = new boolean[N];
		visited[K] = true;
		answer = Integer.MAX_VALUE;
		dfs(0, K, 0);

		System.out.print(answer);
	}

	private static void dfs(int n, int u, int cost) {
		if (n == N - 1) {
			answer = Math.min(answer, cost);
			return;
		}

		for (int v = N - 1; v >= 0; v--) {
			if (visited[v])
				continue;

			visited[v] = true;
			dfs(n + 1, v, cost + dist[u][v]);
			visited[v] = false;
		}
	}
}