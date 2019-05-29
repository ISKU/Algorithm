/*
 * Author: Minho Kim (ISKU)
 * Date: May 29, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1585
 */

import java.io.*;
import java.util.*;

public class Main {

	private static List<Integer>[] network;
	private static int[][] weight, capacity;
	private static int source, sink, vertices;
	private static int N, T, F;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] in = new int[N];
		for (int i = 0; i < N; i++)
			in[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] out = new int[N];
		for (int i = 0; i < N; i++)
			out[i] = Integer.parseInt(st.nextToken());

		vertices = N + N + 2;
		source = N + N;
		sink = N + N + 1;
		weight = new int[vertices][vertices];
		capacity = new int[vertices][vertices];
		network = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++)
			network[i] = new ArrayList<Integer>();

		T = Integer.parseInt(br.readLine());
		F = Integer.parseInt(br.readLine());
		for (int u = 0; u < N; u++) {
			network[source].add(u);
			network[u].add(source);
			network[u + N].add(sink);
			network[sink].add(u + N);
			capacity[source][u] = 1;
			capacity[u + N][sink] = 1;

			for (int v = 0; v < N; v++) {
				int S = out[v] - in[u];
				if (S < 1)
					continue;

				if (S < T) {
					weight[u][v + N] = Math.min((T - S) * (T - S), F);
					weight[v + N][u] = -weight[u][v + N];
				}
				network[u].add(v + N);
				network[v + N].add(u);
				capacity[u][v + N] = 1;
			}
		}

		int[] cost = mcmf();
		System.out.printf("%d %d", cost[0], cost[1]);
	}

	private static int[] mcmf() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] contains = new boolean[vertices];
		int[] dist = new int[vertices];
		int[] path = new int[vertices];
		int[][] flow = new int[vertices][vertices];

		int[] cost = new int[] { 0, 0 };
		int mf = 0;
		while (true) {
			Arrays.fill(dist, Integer.MAX_VALUE);

			q.add(source);
			contains[source] = true;
			dist[source] = 0;
			while (!q.isEmpty()) {
				int u = q.poll();
				contains[u] = false;

				for (int v : network[u]) {
					int w = dist[u] + weight[u][v];
					if (dist[v] > w && capacity[u][v] > flow[u][v]) {
						dist[v] = w;
						path[v] = u;

						if (!contains[v]) {
							q.add(v);
							contains[v] = true;
						}
					}
				}
			}
			if (dist[sink] == Integer.MAX_VALUE)
				break;

			for (int v = sink; v != source; v = path[v]) {
				flow[path[v]][v]++;
				flow[v][path[v]]--;
			}

			mf++;
			cost[0] += dist[sink];
		}
		if (mf != N) {
			System.out.print(-1);
			System.exit(0);
		}

		mf = 0;
		for (int i = 0; i < vertices; i++)
			Arrays.fill(flow[i], 0);
		while (true) {
			Arrays.fill(dist, Integer.MIN_VALUE);

			q.add(source);
			contains[source] = true;
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

			mf++;
			cost[1] += dist[sink];
		}
		if (mf != N) {
			System.out.print(-1);
			System.exit(0);
		}

		return cost;
	}
}