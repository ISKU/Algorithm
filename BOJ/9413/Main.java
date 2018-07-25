/*
 * Author: Minho Kim (ISKU)
 * Date: July 25, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/9413
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] network;
	private static int[][] capacity, flow, cost;
	private static int[] prev, dist;
	private static Queue<Integer> q;
	private static boolean[] contains;
	private static int source, sink, P, Q;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int V = N + N + 5;

			capacity = new int[V][V];
			flow = new int[V][V];
			cost = new int[V][V];
			dist = new int[V];
			network = new ArrayList[V];
			for (int i = 0; i < V; i++)
				network[i] = new ArrayList<Integer>();

			source = N + N + 1;
			P = N + N + 2;
			Q = N + N + 3;
			sink = N + N + 4;
			network[source].add(P);
			network[P].add(source);
			network[Q].add(sink);
			network[sink].add(Q);
			capacity[source][P] = 2;
			capacity[Q][sink] = 2;
			for (int u = 1; u <= N; u++) {
				int v = u + N;
				network[u].add(v);
				network[v].add(u);
				network[P].add(u);
				network[u].add(P);
				network[v].add(Q);
				network[Q].add(v);
				capacity[P][u] = 1;
				capacity[v][Q] = 1;
				capacity[u][v] = 1;
				cost[u][v] = -1;
				cost[v][u] = 1;
			}
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()) + N;
				int v = Integer.parseInt(st.nextToken());
				network[u].add(v);
				network[v].add(u);
				capacity[u][v] = 1;
			}

			int answer = 0;
			while (true) {
				q = new LinkedList<Integer>();
				prev = new int[V];
				contains = new boolean[V];
				Arrays.fill(dist, Integer.MAX_VALUE);

				q.add(source);
				contains[source] = true;
				dist[source] = 0;
				while (!q.isEmpty()) {
					int u = q.poll();
					contains[u] = false;

					for (int v : network[u]) {
						int w = dist[u] + cost[u][v];
						if (capacity[u][v] - flow[u][v] > 0 && dist[v] > w) {
							dist[v] = w;
							prev[v] = u;

							if (!contains[v]) {
								q.add(v);
								contains[v] = true;
							}
						}
					}
				}

				if (prev[sink] == 0)
					break;

				for (int v = sink; v != source; v = prev[v]) {
					answer += cost[prev[v]][v];
					flow[prev[v]][v]++;
					flow[v][prev[v]]--;
				}
			}

			bw.write(-answer + "\n");
		}

		bw.close();
	}
}