/*
 * Author: Minho Kim (ISKU)
 * Date: December 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16681
 */

import java.util.*;
import java.io.*;

public class Main {

	private static List<Edge>[] graph;
	private static int[] height;
	private static int N;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		height = new int[N + 1];
		for (int i = 1; i <= N; i++)
			height[i] = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
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

		long[] path = dijkstra(1);
		long[] reverse = dijkstra(N);
		long answer = Long.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			if (path[i] == Long.MAX_VALUE || reverse[i] == Long.MAX_VALUE)
				continue;
			answer = Math.max(answer, height[i] * E - (path[i] + reverse[i]) * D);
		}
		System.out.print((answer == Long.MIN_VALUE) ? "Impossible" : answer);
	}

	private static long[] dijkstra(int start) {
		Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Long.compare(o1.weight, o2.weight);
			}
		});
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		pq.add(new Edge(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			if (u.weight > dist[u.vertex])
				continue;

			for (Edge v : graph[u.vertex]) {
				if (height[u.vertex] >= height[v.vertex])
					continue;

				long cost = u.weight + v.weight;
				if (cost < dist[v.vertex]) {
					dist[v.vertex] = cost;
					pq.add(new Edge(v.vertex, cost));
				}
			}
		}

		return dist;
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