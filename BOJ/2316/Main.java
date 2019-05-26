/*
 * Author: Minho Kim (ISKU)
 * Date: May 27, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2316
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
		int P = Integer.parseInt(st.nextToken());

		vertices = N * 2 + 1;
		source = 1 + N;
		sink = 2;
		capacity = new int[vertices][vertices];
		flow = new int[vertices][vertices];
		network = new ArrayList[vertices];
		for (int i = 1; i < vertices; i++)
			network[i] = new ArrayList<Integer>();

		for (int u = 1; u <= N; u++) {
			network[u].add(u + N);
			network[u + N].add(u);
			capacity[u][u + N] = 1;
		}
		while (P-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			network[u + N].add(v);
			network[v].add(u + N);
			network[v + N].add(u);
			network[u].add(v + N);
			capacity[u + N][v] += 1;
			capacity[v + N][u] += 1;
		}

		System.out.print(edmondskarp());
	}

	private static int edmondskarp() {
		Queue<Integer> q = new LinkedList<>();
		int[] path = new int[vertices];

		int mf = 0;
		while (true) {
			q.clear();
			Arrays.fill(path, 0);

			q.add(source);
			while (!q.isEmpty()) {
				int u = q.poll();
				if (u == sink)
					break;

				for (int v : network[u]) {
					if (path[v] == 0 && capacity[u][v] > flow[u][v]) {
						q.add(v);
						path[v] = u;
					}
				}
			}
			if (path[sink] == 0)
				break;

			int cf = Integer.MAX_VALUE;
			for (int v = sink; v != source; v = path[v])
				cf = Math.min(cf, capacity[path[v]][v] - flow[path[v]][v]);
			for (int v = sink; v != source; v = path[v]) {
				flow[path[v]][v] += cf;
				flow[v][path[v]] -= cf;
			}

			mf += cf;
		}

		return mf;
	}
}
