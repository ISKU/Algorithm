/*
 * Author: Minho Kim (ISKU)
 * Date: December 8, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://algospot.com/judge/problem/read/BOJ
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int[] dy = new int[] { -1, 0, 1, 0 };
	public static final int[] dx = new int[] { 0, 1, 0, -1 };

	private static int[][] map;
	private static int Y, X;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		map = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			String line = br.readLine();
			for (int x = 0; x < X; x++)
				map[y][x] = line.charAt(x) - '0';
		}

		System.out.print(dijkstra());
	}

	private static int dijkstra() {
		Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
		});
		int[][] dist = new int[Y][X];
		for (int i = 0; i < Y; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		dist[0][0] = 0;
		pq.add(new Edge(0, 0, 0));

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			if (dist[e.y][e.x] < e.weight)
				continue;

			for (int i = 0; i < 4; i++) {
				int y = e.y + dy[i];
				int x = e.x + dx[i];
				if (y < 0 || y >= Y || x < 0 || x >= X)
					continue;

				int cost = e.weight + map[y][x];
				if (cost < dist[y][x]) {
					dist[y][x] = cost;
					pq.add(new Edge(y, x, cost));
				}
			}
		}

		return dist[Y - 1][X - 1];
	}

	private static class Edge {
		public int y, x;
		public int weight;

		public Edge(int y, int x, int weight) {
			this.y = y;
			this.x = x;
			this.weight = weight;
		}
	}
}