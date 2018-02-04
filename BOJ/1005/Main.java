/*
 * Author: Minho Kim (ISKU)
 * Date: February 04, 2018
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
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
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				graph[second].add(first);
			}

			dp = new int[V + 1];
			bw.write(String.valueOf(dfs(Integer.parseInt(br.readLine()))));
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