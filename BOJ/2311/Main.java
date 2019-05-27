/*
 * Author: Minho Kim (ISKU)
 * Date: May 27, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2311
 */

import java.util.*;
import java.io.*;

public class Main {

	private static List<Edge>[] network;
	private static int source, sink, vertices;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		vertices = N + 2;

		source = 0;
		sink = N + 1;
		network = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++)
			network[i] = new ArrayList<Edge>();

		add(source, 1, 0, 2);
		add(N, sink, 0, 2);
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			add(u, v, w, 1);
			add(v, u, w, 1);
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
			q.clear();
			Arrays.fill(contains, false);
			Arrays.fill(dist, Integer.MAX_VALUE);

			q.add(source);
			contains[source] = true;
			dist[source] = 0;
			while (!q.isEmpty()) {
				int u = q.poll();
				contains[u] = false;

				for (Edge edge : network[u]) {
					int v = edge.v;

					int w = dist[u] + edge.weight;
					if (dist[v] > w && edge.capacity > edge.flow) {
						dist[v] = w;
						path[v] = edge;

						if (!contains[v]) {
							q.add(v);
							contains[v] = true;
						}
					}
				}
			}
			if (dist[sink] == Integer.MAX_VALUE)
				break;

			int cf = Integer.MAX_VALUE;
			for (int v = sink; v != source; v = path[v].u)
				cf = Math.min(cf, path[v].capacity - path[v].flow);
			for (int v = sink; v != source; v = path[v].u) {
				path[v].flow += cf;
				path[v].back.flow -= cf;
				cost += path[v].weight;
			}
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