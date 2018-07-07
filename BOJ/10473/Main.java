/*
 * Author: Minho Kim (ISKU)
 * Date: July 7, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10473
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Edge>[] graph;
	private static Point[] vertices;
	private static int N;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Point start = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		Point end = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));

		N = Integer.parseInt(br.readLine());
		vertices = new Point[N + 2];
		graph = new ArrayList[N + 2];
		for (int i = 0; i < graph.length; i++)
			graph[i] = new ArrayList<Edge>();

		vertices[0] = start;
		vertices[N + 1] = end;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			vertices[i] = new Point(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}

		for (int i = 1; i < vertices.length; i++) {
			double w = euclidean(start, vertices[i]);
			graph[0].add(new Edge(i, w / 5));
			graph[i].add(new Edge(0, w / 5));
		}

		for (int u = 1; u < vertices.length; u++) {
			for (int v = u + 1; v < vertices.length; v++) {
				double w = euclidean(vertices[u], vertices[v]);

				if (w > 50) {
					graph[u].add(new Edge(v, ((w - 50) / 5) + 2));
					graph[v].add(new Edge(u, ((w - 50) / 5) + 2));
				} else {
					graph[u].add(new Edge(v, ((50 - w) / 5) + 2));
					graph[v].add(new Edge(u, ((50 - w) / 5) + 2));
				}
			}
		}

		System.out.print(dijkstra(0)[N + 1]);
	}

	private static double[] dijkstra(int start) {
		boolean[] visited = new boolean[N + 2];
		double[] dist = new double[N + 2];
		Arrays.fill(dist, Double.MAX_VALUE);
		dist[start] = 0;
		Queue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Double.compare(o1.w, o2.w);
			}
		}) {{ add(new Edge(start, 0)); }};

		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			visited[u.vertex] = true;

			for (Edge v : graph[u.vertex]) {
				if (visited[v.vertex])
					continue;

				double cost = dist[u.vertex] + v.w;
				if (dist[v.vertex] > cost) {
					dist[v.vertex] = cost;
					pq.add(new Edge(v.vertex, cost));
				}
			}
		}

		return dist;
	}

	private static double euclidean(Point A, Point B) {
		return Math.sqrt(((A.x - B.x) * (A.x - B.x)) + ((A.y - B.y) * (A.y - B.y)));
	}

	private static class Edge {
		public int vertex;
		public double w;

		private Edge(int vertex, double w) {
			this.vertex = vertex;
			this.w = w;
		}
	}

	private static class Point {
		public double x, y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
}