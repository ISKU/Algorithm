/*
 * Author: Minho Kim (ISKU)
 * Date: July 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11657
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Edge>[] graph;
	private static int N;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Edge>();

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Edge(b, c));
		}

		int[] dist = bellmanford(1);
		for (int i = 2; i <= N; i++)
			bw.write(((dist[i] == Integer.MAX_VALUE) ? -1 : dist[i]) + "\n");
		bw.close();
	}

	private static int[] bellmanford(int start) {
		boolean cycle = false;
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		for (int i = 0; i < N; i++) {
			for (int u = 1; u <= N; u++) {
				for (Edge v : graph[u]) {
					int cost = dist[u] + v.weight;
					if (dist[u] != Integer.MAX_VALUE && dist[v.vertex] > cost) {
						dist[v.vertex] = cost;
						if (i == N - 1)
							cycle = true;
					}
				}
			}
		}

		if (cycle) {
			System.out.print(-1);
			System.exit(0);
		}
		return dist;
	}

	private static class Edge {
		public int vertex, weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}