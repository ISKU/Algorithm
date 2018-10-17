/*
 * Author: Minho Kim (ISKU)
 * Date: October 17, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2307
 */

import java.util.*;
import java.io.*;

public class Main {

	private static List<Edge>[] graph;
	private static int[] path;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Edge>();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Edge(v, w));
			graph[v].add(new Edge(u, w));
		}

		path = new int[N + 1];
		int minCost = dijkstra();
		if (minCost == Integer.MAX_VALUE)
			exit();

		int max = 0;
		for (int v = N; v != 0; v = path[v]) {
			int cost = dijkstraForCheck(path[v], v);
			if (cost == Integer.MAX_VALUE)
				exit();

			max = Math.max(max, cost);
		}

		System.out.print(max - minCost);
	}

	private static int dijkstraForCheck(int s, int e) {
		int[] dist = new int[N + 1];
		Queue<Edge> pq = new PriorityQueue<>();

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		pq.add(new Edge(1, 0));

		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			if (u.weight > dist[u.vertex])
				continue;

			for (Edge v : graph[u.vertex]) {
				if ((u.vertex == s && v.vertex == e) || (u.vertex == e && v.vertex == s))
					continue;

				int cost = u.weight + v.weight;
				if (cost < dist[v.vertex]) {
					dist[v.vertex] = cost;
					pq.add(new Edge(v.vertex, cost));
				}
			}
		}

		return dist[N];
	}

	private static int dijkstra() {
		int[] dist = new int[N + 1];
		Queue<Edge> pq = new PriorityQueue<>();

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		pq.add(new Edge(1, 0));

		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			if (u.weight > dist[u.vertex])
				continue;

			for (Edge v : graph[u.vertex]) {
				int cost = u.weight + v.weight;
				if (cost < dist[v.vertex]) {
					dist[v.vertex] = cost;
					path[v.vertex] = u.vertex;
					pq.add(new Edge(v.vertex, cost));
				}
			}
		}

		return dist[N];
	}

	private static void exit() {
		System.out.print(-1);
		System.exit(0);
	}

	private static class Edge implements Comparable<Edge> {
		public int vertex, weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}