/*
 * Author: Minho Kim (ISKU)
 * Date: January 29, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/918/D
 */

import java.util.*;
import java.io.*;

public class D {

	private static ArrayList<Edge>[] graph;
	private static int V, E;
	private static int[][][][] dp;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++)
			graph[i] = new ArrayList<Edge>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int weight = st.nextToken().charAt(0) % 97;
			graph[first].add(new Edge(second, weight));
		}

		dp = new int[V + 1][V + 1][26][3];
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++)
				bw.write(((char) (dfs(i, j, 0, 1) + 64)));
			bw.newLine();
		}

		bw.close();
	}

	private static int dfs(int A, int B, int prev, int turn) {
		if (dp[A][B][prev][turn] != 0)
			return dp[A][B][prev][turn];

		dp[A][B][prev][turn] = (turn == 1) ? 2 : 1;

		if (turn == 1)
			for (Edge e : graph[A])
				if (e.weight >= prev)
					dp[A][B][prev][turn] = Math.min(dp[A][B][prev][turn], dfs(e.vertex, B, e.weight, 2));

		if (turn == 2)
			for (Edge e : graph[B])
				if (e.weight >= prev)
					dp[A][B][prev][turn] = Math.max(dp[A][B][prev][turn], dfs(A, e.vertex, e.weight, 1));

		return dp[A][B][prev][turn];
	}

	private static class Edge {
		public int vertex;
		public int weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}