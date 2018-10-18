/*
 * Author: Minho Kim (ISKU)
 * Date: October 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/14461
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int[] dy = new int[] { -1, 0, 1, 0 };
	public static final int[] dx = new int[] { 0, 1, 0, -1 };
	private static long[][] graph;
	private static int N;
	private static long T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		graph = new long[N + 1][N + 1];
		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= N; x++)
				graph[y][x] = Long.parseLong(st.nextToken());
		}

		System.out.print(dijkstra());
	}

	private static long dijkstra() {
		long[][][] dist = new long[3][N + 1][N + 1];
		Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Long.compare(o1.weight, o2.weight);
			}
		});

		for (int k = 0; k < 3; k++)
			for (int y = 1; y <= N; y++)
				Arrays.fill(dist[k][y], Long.MAX_VALUE);
		for (int k = 0; k < 3; k++)
			dist[k][1][1] = 0;
		pq.add(new Edge(1, 1, 0, 0));

		while (!pq.isEmpty()) {
			Edge u = pq.poll();
			if (u.weight > dist[u.count][u.y][u.x])
				continue;

			for (int i = 0; i < 4; i++) {
				int y = u.y + dy[i];
				int x = u.x + dx[i];
				if (y <= 0 || y > N || x <= 0 || x > N)
					continue;

				long cost = u.weight + T;
				int count = (u.count == 2) ? 0 : u.count + 1;
				if (u.count == 2)
					cost += graph[y][x];

				if (cost < dist[count][y][x]) {
					dist[count][y][x] = cost;
					pq.add(new Edge(y, x, cost, count));
				}
			}
		}

		return Math.min(dist[0][N][N], Math.min(dist[1][N][N], dist[2][N][N]));
	}

	private static class Edge {
		public int y, x;
		public long weight;
		public int count;

		public Edge(int y, int x, long weight, int count) {
			this.y = y;
			this.x = x;
			this.weight = weight;
			this.count = count;
		}
	}
}