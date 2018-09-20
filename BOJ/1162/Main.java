/*
 * Author: Minho Kim (ISKU)
 * Date: September 21, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1162
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Edge>[] graph;
	private static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Edge>();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			graph[u].add(new Edge(v, w));
			graph[v].add(new Edge(u, w));
		}

		long[][] cost = dijkstra();
		long min = Long.MAX_VALUE;
		for (int i = 0; i <= K; i++)
			min = Math.min(min, cost[i][N]);

		System.out.print(min);
	}

	private static long[][] dijkstra() {
		Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Long.compare(o1.weight, o2.weight);
			}
		});
		long[][] dist = new long[K + 1][N + 1];
		for (int i = 0; i <= K; i++)
			Arrays.fill(dist[i], Long.MAX_VALUE);

		pq.add(new Edge(1, 0, 0));
		dist[0][1] = 0;

		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			if (u.weight > dist[u.k][u.vertex])
				continue;

			for (Edge v : graph[u.vertex]) {
				if (u.k + 1 <= K) {
					long cost = u.weight;
					if (cost < dist[u.k + 1][v.vertex]) {
						dist[u.k + 1][v.vertex] = cost;
						pq.add(new Edge(v.vertex, cost, u.k + 1));
					}
				}

				long cost = u.weight + v.weight;
				if (cost < dist[u.k][v.vertex]) {
					dist[u.k][v.vertex] = cost;
					pq.add(new Edge(v.vertex, cost, u.k));
				}
			}
		}

		return dist;
	}

	private static class Edge {
		public int vertex, k;
		public long weight;

		public Edge(int vertex, long weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public Edge(int vertex, long weight, int k) {
			this.vertex = vertex;
			this.weight = weight;
			this.k = k;
		}
	}
}