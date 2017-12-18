/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.12.18
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14953
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<ArrayList<Integer>> graph;
	private static int[] dp;
	private static int V, E;

	public static void main(String... args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer parser = new StringTokenizer(input.readLine());
		V = Integer.parseInt(parser.nextToken());
		E = Integer.parseInt(parser.nextToken());

		dp = new int[V];
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V; i++)
			graph.add(new ArrayList<Integer>());

		for (int i = 0; i < E; i++) {
			parser = new StringTokenizer(input.readLine());
			int first = Integer.parseInt(parser.nextToken());
			int second = Integer.parseInt(parser.nextToken());
			graph.get(first).add(second);
			graph.get(second).add(first);
		}

		int max = 0;
		for (int i = 0; i < V; i++) {
			dp[i] = dfs(i, 1);
			max = Math.max(max, dp[i]);
		}

		System.out.print(max);
	}

	private static int dfs(int vertex, int length) {
		if (dp[vertex] != 0)
			return dp[vertex] + length - 1;

		int max = length;
		for (int dest : graph.get(vertex))
			if (graph.get(vertex).size() < graph.get(dest).size())
				max = Math.max(max, dfs(dest, length + 1));

		return max;
	}
}