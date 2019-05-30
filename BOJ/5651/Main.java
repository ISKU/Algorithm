/*
 * Author: Minho Kim (ISKU)
 * Date: May 28, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/5651
 */

import java.util.*;
import java.io.*;

public class Main {

	private static List<Edge>[] network;
	private static Edge[] edges;
	private static int source, sink, N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			source = 1;
			sink = N;
			network = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				network[i] = new ArrayList<Edge>();

			edges = new Edge[M];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int capacity = Integer.parseInt(st.nextToken());
				edges[i] = add(u, v, capacity);
			}

			maximumFlow();
			bw.write(bfs() + "\n");
		}

		bw.close();
	}

	private static void maximumFlow() {
		Queue<Integer> q = new LinkedList<>();
		Edge[] path = new Edge[N + 1];

		while (true) {
			q.clear();
			Arrays.fill(path, null);

			q.add(source);
			while (!q.isEmpty()) {
				int u = q.poll();
				if (u == sink)
					break;

				for (Edge edge : network[u]) {
					int v = edge.v;
					if (path[v] == null && edge.capacity > edge.flow) {
						q.add(v);
						path[v] = edge;
					}
				}
			}
			if (path[sink] == null)
				break;

			int cf = Integer.MAX_VALUE;
			for (int v = sink; v != source; v = path[v].u)
				cf = Math.min(cf, path[v].capacity - path[v].flow);
			for (int v = sink; v != source; v = path[v].u) {
				path[v].flow += cf;
				path[v].back.flow -= cf;
			}
		}
	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		int link = 0;
		for (Edge candidate : edges) {
			if (candidate.capacity > candidate.flow)
				continue;
			candidate.capacity--;

			q.clear();
			Arrays.fill(visited, false);
			q.add(candidate.u);
			visited[candidate.u] = true;
			while (!q.isEmpty()) {
				int u = q.poll();
				if (u == candidate.v)
					break;

				for (Edge edge : network[u]) {
					int v = edge.v;
					if (!visited[v] && edge.capacity > edge.flow) {
						q.add(v);
						visited[v] = true;
					}
				}
			}

			if (!visited[candidate.v])
				link++;
			candidate.capacity++;
		}

		return link;
	}

	private static Edge add(int u, int v, int capacity) {
		Edge uv = new Edge(u, v, capacity);
		Edge vu = new Edge(v, u, 0);
		uv.back = vu;
		vu.back = uv;
		network[u].add(uv);
		network[v].add(vu);
		return uv;
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
