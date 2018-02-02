/*
 * Author: Minho Kim (ISKU)
 * Date: January 31, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/919/D
 */

import java.util.*;
import java.io.*;

public class D {

	private static ArrayList<Integer>[] graph;
	private static int[] visited;
	private static int[] letter;
	private static int[][] dp;
	private static int V, E;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		String path = br.readLine();
		letter = new int[V + 1];
		for (int i = 1; i <= V; i++)
			letter[i] = path.charAt(i - 1) - 'a';

		graph = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}

		dp = new int[V + 1][26];
		visited = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			if (visited[i] == 0 && dfs(i)) {
				System.out.print(-1);
				System.exit(0);
			}
		}

		int answer = 0;
		for (int i = 1; i <= V; i++)
			for (int j = 0; j < 26; j++)
				answer = Math.max(answer, dp[i][j]);
		System.out.print(answer);
	}

	private static boolean dfs(int vertex) {
		visited[vertex] = 1;

		for (int to : graph[vertex]) {
			if (visited[to] == 1)
				return true;
			if (visited[to] == 0 && dfs(to))
				return true;

			for (int i = 0; i < 26; i++)
				dp[vertex][i] = Math.max(dp[vertex][i], dp[to][i]);
		}

		dp[vertex][letter[vertex]]++;
		visited[vertex] = 2;
		return false;
	}
}