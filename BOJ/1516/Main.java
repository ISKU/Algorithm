/*
 * Author: Minho Kim (ISKU)
 * Date: February 05, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1516
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] graph;
	private static int[] cost, dp;
	private static int V;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());

		cost = new int[V + 1];
		graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				int vertex = Integer.parseInt(st.nextToken());
				if (vertex != -1)
					graph[i].add(vertex);
			}
		}

		dp = new int[V + 1];
		for (int i = 1; i <= V; i++)
			dfs(i);

		for (int i = 1; i <= V; i++) {
			bw.write(String.valueOf(dp[i]));
			bw.newLine();
		}
		bw.close();
	}

	private static int dfs(int vertex) {
		if (dp[vertex] != 0)
			return dp[vertex];

		dp[vertex] = cost[vertex];
		for (int to : graph[vertex])
			dp[vertex] = Math.max(dp[vertex], dfs(to) + cost[vertex]);

		return dp[vertex];
	}
}