/*
 * Author: Minho Kim (ISKU)
 * Date: May 24, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17222
 */

import java.util.*;
import java.io.*;

public class Main {

	private static List<Integer>[] network;
	private static long[][] capacity, flow;
	private static int source, sink;
	private static int N, M;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		source = N + M + 1;
		sink = 0;
		capacity = new long[N + M + 2][N + M + 2];
		flow = new long[N + M + 2][N + M + 2];
		network = new ArrayList[N + M + 2];
		for (int i = 0; i < N + M + 2; i++)
			network[i] = new ArrayList<Integer>();

		st = new StringTokenizer(br.readLine());
		int[] limit = new int[N + M + 2];
		for (int u = 1; u <= N; u++) {
			int w = Integer.parseInt(st.nextToken());
			limit[u] = w;

			network[u].add(sink);
			network[sink].add(u);
			capacity[u][sink] = Long.MAX_VALUE;
		}
		st = new StringTokenizer(br.readLine());
		for (int u = N + 1; u <= N + M; u++) {
			int w = Integer.parseInt(st.nextToken());
			limit[u] = w;

			network[u].add(source);
			network[source].add(u);
			capacity[source][u] = w;
		}
		for (int u = N + 1; u <= N + M; u++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			for (int i = 0; i < n; i++) {
				int v = Integer.parseInt(st.nextToken());
				network[u].add(v);
				network[v].add(u);
				capacity[u][v] += limit[v];
			}
		}

		long total = 0;
		while (true) {
			Queue<Integer> q = new LinkedList<Integer>();
			int[] prev = new int[N + M + 2];
			q.add(source);

			while (!q.isEmpty()) {
				int u = q.poll();
				if (u == sink)
					break;

				for (int v : network[u]) {
					if (prev[v] == 0 && capacity[u][v] - flow[u][v] > 0) {
						q.add(v);
						prev[v] = u;
					}
				}
			}
			if (prev[sink] == 0)
				break;

			long cf = Long.MAX_VALUE;
			for (int v = sink; v != source; v = prev[v])
				cf = Math.min(cf, capacity[prev[v]][v] - flow[prev[v]][v]);

			for (int v = sink; v != source; v = prev[v]) {
				flow[prev[v]][v] += cf;
				flow[v][prev[v]] -= cf;
			}

			total += cf;
		}

		System.out.print(total);
	}
}