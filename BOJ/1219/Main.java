/*
 * Author: Minho Kim (ISKU)
 * Date: July 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1219
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Edge>[] graph;
	private static int[] earn;
	private static boolean[] visited;
	private static int N;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		earn = new int[N];
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<Edge>();

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Edge(v, -w));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			earn[i] = Integer.parseInt(st.nextToken());

		long[] dist = bellmanford(start);
		if (dist[end] == Long.MIN_VALUE)
			System.out.print("gg");
		else
			System.out.print(bfs(end) ? "Gee" : dist[end]);
	}

	private static long[] bellmanford(int start) {
		long[] dist = new long[N];
		Arrays.fill(dist, Long.MIN_VALUE);
		dist[start] = earn[start];

		for (int i = 0; i < N; i++) {
			for (int u = 0; u < N; u++) {
				for (Edge v : graph[u]) {
					long cost = dist[u] + v.weight + earn[v.vertex];
					if (dist[u] != Long.MIN_VALUE && dist[v.vertex] < cost) {
						dist[v.vertex] = cost;
						if (i == N - 1)
							visited[v.vertex] = true;
					}
				}
			}
		}

		return dist;
	}

	private static boolean bfs(int end) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++)
			if (visited[i])
				q.add(i);

		while (!q.isEmpty()) {
			int u = q.poll();
			if (u == end)
				return true;

			for (Edge v : graph[u]) {
				if (!visited[v.vertex]) {
					q.add(v.vertex);
					visited[v.vertex] = true;
				}
			}
		}

		return false;
	}

	private static class Edge {
		public int vertex, weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}