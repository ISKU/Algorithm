/*
 * Author: Minho Kim (ISKU)
 * Date: July 30, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1005
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] graph;
	private static int[] cost, dp;
	private static int V, E;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());

		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			graph = new ArrayList[V + 1];
			cost = new int[V + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<Integer>();
				cost[i] = Integer.parseInt(st.nextToken());
			}

			while (E-- > 0) {
				st = new StringTokenizer(br.readLine());
				int v = Integer.parseInt(st.nextToken());
				int u = Integer.parseInt(st.nextToken());
				graph[u].add(v);
			}

			dp = new int[V + 1];
			Arrays.fill(dp, -1);
			bw.write(dfs(Integer.parseInt(br.readLine())) + "\n");
		}

		bw.close();
	}

	private static int dfs(int u) {
		if (dp[u] != -1)
			return Math.max(dp[u], cost[u]);

		dp[u] = 0;
		for (int v : graph[u])
			dp[u] = Math.max(dp[u], dfs(v) + cost[u]);

		return Math.max(dp[u], cost[u]);
	}
}