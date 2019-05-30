/*
 * Author: Minho Kim (ISKU)
 * Date: May 31, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1657
 */

import java.io.*;
import java.util.*;

public class Main {

	public static final int[][] table = new int[][] { { 10, 8, 7, 5, 1 }, { 8, 6, 4, 3, 1 }, { 7, 4, 3, 2, 1 }, { 5, 3, 2, 2, 1 }, { 1, 1, 1, 1, 0 } };
	public static final int[] dy = new int[] { -1, 1, 0, 0 };
	public static final int[] dx = new int[] { 0, 0, -1, 1 };

	private static List<Integer>[] network;
	private static int[][] weight, capacity;
	private static int source, sink, vertices;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] tofu = new int[N][M];
		for (int y = 0; y < N; y++) {
			char[] line = br.readLine().toCharArray();
			for (int x = 0; x < M; x++) {
				if (line[x] == 'F')
					tofu[y][x] = 4;
				else
					tofu[y][x] = line[x] - 'A';
			}
		}

		vertices = N * M + 2;
		source = N * M;
		sink = N * M + 1;
		weight = new int[vertices][vertices];
		capacity = new int[vertices][vertices];
		network = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++)
			network[i] = new ArrayList<Integer>();

		for (int y = 0; y < N; y++) {
			for (int x = y % 2; x < M; x += 2) {
				int u = y * M + x;
				add(source, u, 0, 1);

				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny < 0 || ny >= N || nx < 0 || nx >= M)
						continue;

					int v = ny * M + nx;
					add(u, v, table[tofu[y][x]][tofu[ny][nx]], 1);
				}
			}
		}
		for (int v = 0; v < N * M; v++)
			add(v, sink, 0, 1);

		System.out.print(mcmf());
	}

	private static int mcmf() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] contains = new boolean[vertices];
		int[] dist = new int[vertices];
		int[] path = new int[vertices];
		int[][] flow = new int[vertices][vertices];

		int cost = 0;
		while (true) {
			Arrays.fill(dist, Integer.MIN_VALUE);

			q.add(source);
			dist[source] = 0;
			while (!q.isEmpty()) {
				int u = q.poll();
				contains[u] = false;

				for (int v : network[u]) {
					int w = dist[u] + weight[u][v];
					if (dist[v] < w && capacity[u][v] > flow[u][v]) {
						dist[v] = w;
						path[v] = u;

						if (!contains[v]) {
							q.add(v);
							contains[v] = true;
						}
					}
				}
			}
			if (dist[sink] == Integer.MIN_VALUE)
				break;

			for (int v = sink; v != source; v = path[v]) {
				flow[path[v]][v]++;
				flow[v][path[v]]--;
			}

			cost += dist[sink];
		}

		return cost;
	}

	private static void add(int u, int v, int w, int c) {
		network[u].add(v);
		network[v].add(u);
		weight[u][v] = w;
		weight[v][u] = -w;
		capacity[u][v] = c;
		capacity[v][u] = 0;
	}
}