/*
 * Author: Minho Kim (ISKU)
 * Date: May 31, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/11378
 */

import java.io.*;
import java.util.*;

public class Main {

	private static List<Integer>[] network;
	private static int[][] capacity, flow;
	private static int source, sink, vertices;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		vertices = N + M + 3;
		source = 0;
		sink = N + M + 2;
		capacity = new int[vertices][vertices];
		flow = new int[vertices][vertices];
		network = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++)
			network[i] = new ArrayList<Integer>();

		add(source, N + M + 1, K);
		for (int u = 1; u <= N; u++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());

			for (int i = 0; i < T; i++) {
				int v = Integer.parseInt(st.nextToken());
				add(u, v + N, 1);
			}
			add(source, u, 1);
			add(N + M + 1, u, K);
		}
		for (int v = 1; v <= M; v++)
			add(v + N, sink, 1);

		System.out.print(dinic());
	}

	private static int dinic() {
		Queue<Integer> q = new LinkedList<>();
		int[] level = new int[vertices];
		int[] blocked = new int[vertices];

		int mf = 0;
		while (true) {
			Arrays.fill(level, 0);

			q.add(source);
			level[source] = 1;
			while (!q.isEmpty()) {
				int u = q.poll();

				for (int v : network[u]) {
					if (level[v] == 0 && capacity[u][v] > flow[u][v]) {
						q.add(v);
						level[v] = level[u] + 1;
					}
				}
			}
			if (level[sink] == 0)
				break;

			Arrays.fill(blocked, 0);
			while (true) {
				int cf = flow(source, Integer.MAX_VALUE, level, blocked);
				if (cf == 0)
					break;

				mf += cf;
			}
		}

		return mf;
	}

	private static int flow(int u, int cf, int[] level, int[] blocked) {
		if (u == sink)
			return cf;

		while (blocked[u] < network[u].size()) {
			int v = network[u].get(blocked[u]++);

			if (level[u] + 1 == level[v] && capacity[u][v] > flow[u][v]) {
				int f = flow(v, Math.min(cf, capacity[u][v] - flow[u][v]), level, blocked);
				if (f > 0) {
					flow[u][v] += f;
					flow[v][u] -= f;
					return f;
				}
			}
		}

		return 0;
	}

	private static void add(int u, int v, int c) {
		network[u].add(v);
		network[v].add(u);
		capacity[u][v] += c;
	}
}