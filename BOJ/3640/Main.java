/*
 * Author: Minho Kim (ISKU)
 * Date: July 22, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3640
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] network;
	private static int[][] capacity, flow, cost;
	private static int[] prev, dist;
	private static Queue<Integer> q;
	private static boolean[] contains;
	private static int source, sink;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String line = br.readLine();
			if (line == null)
				break;

			StringTokenizer st = new StringTokenizer(line);
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			capacity = new int[V + V + 1][V + V + 1];
			flow = new int[V + V + 1][V + V + 1];
			cost = new int[V + V + 1][V + V + 1];
			dist = new int[V + V + 1];
			network = new ArrayList[V + V + 1];
			for (int i = 1; i <= V + V; i++)
				network[i] = new ArrayList<Integer>();

			source = 1;
			sink = V + V;
			for (int u = 1; u <= V; u++) {
				network[u].add(u + V);
				network[u + V].add(u);
				capacity[u][u + V] = 1;
			}
			capacity[source][source + V] = 2;
			capacity[V][sink] = 2;
			while (E-- > 0) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				network[u + V].add(v);
				network[v].add(u + V);
				cost[u + V][v] = w;
				cost[v][u + V] = -w;
				capacity[u + V][v] = 1;
			}

			int answer = 0;
			while (true) {
				q = new LinkedList<Integer>();
				prev = new int[V + V + 1];
				contains = new boolean[V + V + 1];
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

			bw.write(answer + "\n");
		}

		bw.close();
	}
}