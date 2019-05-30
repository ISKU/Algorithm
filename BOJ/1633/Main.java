/*
 * Author: Minho Kim (ISKU)
 * Date: May 30, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1633
 */

import java.util.*;
import java.io.*;

public class Main {

	private static List<Edge>[] network;
	private static int source, sink, vertices;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> black = new ArrayList<>();
		List<Integer> white = new ArrayList<>();
		String line = null;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			black.add(Integer.parseInt(st.nextToken()));
			white.add(Integer.parseInt(st.nextToken()));
		}

		int N = black.size();
		vertices = N * 3 + 4;
		source = vertices - 2;
		sink = vertices - 1;
		network = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++)
			network[i] = new ArrayList<Edge>();

		add(source, N * 3, 0, 15);
		add(source, 1 + (N * 3), 0, 15);
		for (int u = 0; u < N; u++) {
			add(N * 3, u, black.get(u), 1);
			add(1 + (N * 3), u + N, white.get(u), 1);
			add(u, u + (2 * N), 0, 1);
			add(u + N, u + (2 * N), 0, 1);
			add(u + (2 * N), sink, 0, 1);
		}

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
				path[v].flow += cf;
				path[v].back.flow -= cf;
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