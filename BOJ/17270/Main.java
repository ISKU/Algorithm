/*
 * Author: Minho Kim (ISKU)
 * Date: June 6, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17270
 */

import java.io.*;
import java.util.*;

public class Main {

	private static List<Edge>[] graph;
	private static int V;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++)
			graph[i] = new ArrayList<Edge>();

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Edge(v, w));
			graph[v].add(new Edge(u, w));
		}

		st = new StringTokenizer(br.readLine());
		int J = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] jh = dijkstra(J);
		int[] sh = dijkstra(S);
		int cost = Integer.MAX_VALUE;
		int candidate = Integer.MAX_VALUE;
		int answer = -1;
		for (int v = V; v >= 1; v--) {
			if (v == J || v == S || jh[v] == Integer.MAX_VALUE || sh[v] == Integer.MAX_VALUE)
				continue;

			cost = Math.min(cost, jh[v] + sh[v]);
		}
		for (int v = V; v >= 1; v--) {
			if (v == J || v == S || jh[v] == Integer.MAX_VALUE || sh[v] == Integer.MAX_VALUE)
				continue;
			if (cost != jh[v] + sh[v] || jh[v] > sh[v])
				continue;

			if (candidate >= jh[v]) {
				candidate = jh[v];
				answer = v;
			}
		}

		System.out.print(answer);
	}

	private static int[] dijkstra(int start) {
		Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
		});
		int[] dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		pq.add(new Edge(start, 0));
		dist[start] = 0;
		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			if (u.weight > dist[u.vertex])
				continue;

			for (Edge v : graph[u.vertex]) {
				int cost = u.weight + v.weight;
				if (cost < dist[v.vertex]) {
					dist[v.vertex] = cost;
					pq.add(new Edge(v.vertex, cost));
				}
			}
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