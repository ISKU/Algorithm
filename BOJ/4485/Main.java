/* 
 * Author: Minho Kim (ISKU)
 * Date: 2017.07.30
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/4485
 */

import java.util.*;

public class Main {

	private static int[][] graph;
	private static int N;

	public static void main(String... args) {
		Scanner input = new Scanner(System.in);

		for (int tCase = 1;; tCase++) {
			N = input.nextInt();
			if (N == 0)
				break;

			graph = new int[N][N];
			for (int y = 0; y < N; y++)
				for (int x = 0; x < N; x++)
					graph[y][x] = input.nextInt();

			System.out.printf("Problem %d: %d\n", tCase, dijkstra(0, 0));
		}
	}

	private static int dijkstra(final int m, final int n) {
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>(new Comparator<Edge>() {
			@Override
			public int compare(Edge A, Edge B) {
				return A.weight - B.weight;
			}
		}) {{ add(new Edge(m, n, graph[m][n])); }};

		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(dist[i], -1);
		dist[m][n] = 0;

		while (!pQueue.isEmpty()) {
			Edge vertex = pQueue.poll();
			int y = vertex.y;
			int x = vertex.x;
			int weight = vertex.weight;

			if (y - 1 >= 0 && (dist[y - 1][x] == -1 || dist[y - 1][x] > weight + graph[y - 1][x])) {
				dist[y - 1][x] = weight + graph[y - 1][x];
				pQueue.add(new Edge(y - 1, x, weight + graph[y - 1][x]));
			}
			if (y + 1 < N && (dist[y + 1][x] == -1 || dist[y + 1][x] > weight + graph[y + 1][x])) {
				dist[y + 1][x] = weight + graph[y + 1][x];
				pQueue.add(new Edge(y + 1, x, weight + graph[y + 1][x]));
			}
			if (x - 1 >= 0 && (dist[y][x - 1] == -1 || dist[y][x - 1] > weight + graph[y][x - 1])) {
				dist[y][x - 1] = weight + graph[y][x - 1];
				pQueue.add(new Edge(y, x - 1, weight + graph[y][x - 1]));
			}
			if (x + 1 < N && (dist[y][x + 1] == -1 || dist[y][x + 1] > weight + graph[y][x + 1])) {
				dist[y][x + 1] = weight + graph[y][x + 1];
				pQueue.add(new Edge(y, x + 1, weight + graph[y][x + 1]));
			}
		}

		return dist[N - 1][N - 1];
	}

	private static class Edge {
		public int y;
		public int x;
		public int weight;

		public Edge(int y, int x, int weight) {
			this.y = y;
			this.x = x;
			this.weight = weight;
		}
	}
}