/*
 * Author: Minho Kim (ISKU)
 * Date: May 30, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/6241
 */

import java.io.*;
import java.util.*;

public class Main {

	private static List<Edge>[] network;
	private static int source, sink, vertices;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int F = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		vertices = N + N + F + D + 2;
		source = 0;
		sink = vertices - 1;
		network = new ArrayList[vertices];
		for (int i = 0; i < vertices; i++)
			network[i] = new ArrayList<Edge>();

		for (int f = 1; f <= F; f++)
			add(source, f + (N + N), 1);
		for (int d = 1; d <= D; d++)
			add(d + (N + N + F), sink, 1);
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int Fi = Integer.parseInt(st.nextToken());
			int Di = Integer.parseInt(st.nextToken());

			while (Fi-- > 0) {
				int f = Integer.parseInt(st.nextToken());
				add(f + (N + N), n, 1);
			}
			while (Di-- > 0) {
				int d = Integer.parseInt(st.nextToken());
				add(n + N, d + (N + N + F), 1);
			}
			add(n, n + N, 1);
		}

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

				for (Edge edge : network[u]) {
					int v = edge.v;

					if (level[v] == 0 && edge.capacity > edge.flow) {
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
			Edge edge = network[u].get(blocked[u]);
			int v = edge.v;

			if (level[u] + 1 == level[v] && edge.capacity > edge.flow) {
				int f = flow(v, Math.min(cf, edge.capacity - edge.flow), level, blocked);
				if (f > 0) {
					edge.flow += f;
					edge.back.flow -= f;
					return f;
				}
			}

			blocked[u]++;
		}

		return 0;
	}

	private static void add(int u, int v, int capacity) {
		Edge uv = new Edge(u, v, capacity);
		Edge vu = new Edge(v, u, 0);
		uv.back = vu;
		vu.back = uv;
		network[u].add(uv);
		network[v].add(vu);
	}

	private static class Edge {
		public int u, v;
		public int capacity, flow;
		public Edge back;

		public Edge(int u, int v, int capacity) {
			this.u = u;
			this.v = v;
			this.capacity = capacity;
		}
	}
}