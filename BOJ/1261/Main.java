/*
 * Author: Minho Kim (ISKU)
 * Date: January 24, 2018
 * E-mail: minho1a@hanmail.net
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1261
 */

import java.util.*;

public class Main {

	private static int Y, X;
	private static int[][] graph;

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();

		graph = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			String[] line = sc.next().split("");
			for (int x = 0; x < X; x++)
				graph[y][x] = Integer.parseInt(line[x]);
		}

		int[][] dist = dijkstra(0, 0);
		System.out.print(dist[Y - 1][X - 1]);
	}

	private static int[][] dijkstra(int startY, int startX) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		int[][] dist = new int[Y][X];
		for (int y = 0; y < Y; y++)
			Arrays.fill(dist[y], -1);

		dist[startY][startX] = 0;
		pq.add(new Edge(startY, startX, 0));

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int y = edge.y;
			int x = edge.x;

			if (y - 1 >= 0 && (dist[y - 1][x] == -1 || dist[y - 1][x] > graph[y - 1][x] + dist[y][x])) {
				dist[y - 1][x] = graph[y - 1][x] + dist[y][x];
				pq.add(new Edge(y - 1, x, graph[y - 1][x] + dist[y][x]));
			}
			if (y + 1 < Y && (dist[y + 1][x] == -1 || dist[y + 1][x] > graph[y + 1][x] + dist[y][x])) {
				dist[y + 1][x] = graph[y + 1][x] + dist[y][x];
				pq.add(new Edge(y + 1, x, graph[y + 1][x] + dist[y][x]));
			}
			if (x - 1 >= 0 && (dist[y][x - 1] == -1 || dist[y][x - 1] > graph[y][x - 1] + dist[y][x])) {
				dist[y][x - 1] = graph[y][x - 1] + dist[y][x];
				pq.add(new Edge(y, x - 1, graph[y][x - 1] + dist[y][x]));
			}
			if (x + 1 < X && (dist[y][x + 1] == -1 || dist[y][x + 1] > graph[y][x + 1] + dist[y][x])) {
				dist[y][x + 1] = graph[y][x + 1] + dist[y][x];
				pq.add(new Edge(y, x + 1, graph[y][x + 1] + dist[y][x]));
			}
		}

		return dist;
	}

	private static class Edge implements Comparable<Edge> {
		public int y, x;
		public int weight;

		public Edge(int y, int x, int wegiht) {
			this.y = y;
			this.x = x;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
}