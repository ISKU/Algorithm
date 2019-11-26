/*
 * Author: Minho Kim (ISKU)
 * Date: November 25, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/18126
 */

import java.io.*;
import java.util.*;

public class Main {

	private static List<Edge>[] graph;
	private static boolean[] visited;
	private static int N;
	private static long answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Edge>();
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Edge(v, w));
			graph[v].add(new Edge(u, w));
		}

		visited = new boolean[N + 1];
		answer = 0;
		dfs(1, 0);

		System.out.println(answer);
	}

	private static void dfs(int u, long dist) {
		visited[u] = true;
		if (u != 1 && graph[u].size() == 1)
			answer = Math.max(answer, dist);

		for (Edge v : graph[u])
			if (!visited[v.vertex])
				dfs(v.vertex, dist + v.weight);
	}

	private static class Edge {
		public int vertex;
		public long weight;

		public Edge(int vertex, long weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}
