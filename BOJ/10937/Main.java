/*
 * Author: Minho Kim (ISKU)
 * Date: May 28, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10937
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[][] table = new int[][] { { 100, 70, 40 }, { 70, 50, 30 }, { 40, 30, 20 } };
	public static final int[] dy = new int[] { -1, 1, 0, 0 };
	public static final int[] dx = new int[] { 0, 0, -1, 1 };

	private static List<Edge>[] network;
	private static int source, sink, vertices;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[][] tofu = new char[N][N];
		for (int y = 0; y < N; y++)
			tofu[y] = br.readLine().toCharArray();

		vertices = N * N + 2;
		source = N * N;
		sink = N * N + 1;
		network = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++)
			network[i] = new ArrayList<Edge>();

		for (int y = 0; y < N; y++) {
			for (int x = y % 2; x < N; x += 2) {
				int u = y * N + x;
				add(source, u, 0, 1);

				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny < 0 || ny >= N || nx < 0 || nx >= N)
						continue;

					int v = ny * N + nx;
					if (tofu[y][x] != 'F' && tofu[ny][nx] != 'F')
						add(u, v, table[tofu[y][x] - 'A'][tofu[ny][nx] - 'A'], 1);
				}
			}
		}
		for (int u = N * N - 1; u >= 0; u--)
			add(u, sink, 0, 1);

		System.out.print(mcmf());
	}

	private static int mcmf() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] contains = new boolean[vertices];
		int[] dist = new int[vertices];
		Edge[] path = new Edge[vertices];

		int cost = 0;
		while (true) {
			Arrays.fill(dist, Integer.MIN_VALUE);

			q.add(source);
			contains[source] = true;
			dist[source] = 0;
			while (!q.isEmpty()) {
				int u = q.poll();
				contains[u] = false;

				for (Edge edge : network[u]) {
					int v = edge.v;

					int w = dist[u] + edge.weight;
					if (dist[v] < w && edge.capacity > edge.flow) {
						dist[v] = w;
						path[v] = edge;

						if (!contains[v]) {
							q.add(v);
							contains[v] = true;
						}
					}
				}
			}
			if (dist[sink] == Integer.MIN_VALUE)
				break;

			int cf = Integer.MAX_VALUE;
			for (int v = sink; v != source; v = path[v].u)
				cf = Math.min(cf, path[v].capacity - path[v].flow);
			for (int v = sink; v != source; v = path[v].u) {
				path[v].flow++;
				path[v].back.flow--;
			}

			cost += dist[sink];
		}

		return cost;
	}

	private static void add(int u, int v, int weight, int capacity) {
		Edge uv = new Edge(u, v, weight, capacity);
		Edge vu = new Edge(v, u, -weight, 0);
		uv.back = vu;
		vu.back = uv;
		network[u].add(uv);
		network[v].add(vu);
	}

	private static class Edge {
		public int u, v;
		public int weight, capacity, flow;
		public Edge back;

		public Edge(int u, int v, int weight, int capacity) {
			this.u = u;
			this.v = v;
			this.weight = weight;
			this.capacity = capacity;
		}
	}
}