/*
 * Author: Minho Kim (ISKU)
 * Date: September 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16167
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Edge>[] graph;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Edge>();
		while (R-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int fare = Integer.parseInt(st.nextToken());
			int extra = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			int cost = (time <= 10) ? fare : (time - 10) * extra + fare;
			graph[u].add(new Edge(v, cost));
		}

		int[] dist = dijkstra();

		if (dist[N] == Integer.MAX_VALUE)
			System.out.printf("It is not a great way.");
		else
			System.out.printf("%d %d", dist[N], findPath(dist));
	}

	private static int findPath(int[] dist) {
		Queue<Edge> q = new LinkedList<>();
		q.add(new Edge(1, 0, 1));

		int path = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Edge u = q.poll();
			if (u.vertex == N)
				path = Math.min(path, u.path);

			for (Edge v : graph[u.vertex]) {
				int cost = u.weight + v.weight;
				if (dist[v.vertex] == cost)
					q.add(new Edge(v.vertex, cost, u.path + 1));
			}
		}

		return path;
	}

	private static int[] dijkstra() {
		Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
		});
		int[] dist = new int[N + 1];

		pq.add(new Edge(1, 0));
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;

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
		public int vertex, weight, path;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public Edge(int vertex, int weight, int path) {
			this.vertex = vertex;
			this.weight = weight;
			this.path = path;
		}
	}
}