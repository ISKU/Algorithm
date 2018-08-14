/*
 * Author: Minho Kim (ISKU)
 * Date: August 9, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1626
 */

import java.util.*;
import java.io.*;

public class Main {

	private static Edge[] edges;
	private static ArrayList<Edge>[] mst;
	private static int[][] parent, pmax;
	private static int[] height, root;
	private static boolean[] visited, mstEdge;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		H = (int) Math.ceil(Math.log(V) / Math.log(2));
		parent = new int[V + 1][H + 1];
		pmax = new int[V + 1][H + 1];
		height = new int[V + 1];
		visited = new boolean[V + 1];
		mstEdge = new boolean[E];
		root = new int[V + 1];
		mst = new ArrayList[V + 1];
		for (int v = 1; v <= V; v++)
			root[v] = v;
		for (int i = 1; i <= V; i++)
			mst[i] = new ArrayList<Edge>();

		edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(u, v, w);
		}
		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});

		long cost = 0;
		int count = 0;
		for (int i = 0; i < E; i++) {
			Edge e = edges[i];
			if (find(e.u) != find(e.v)) {
				mst[e.u].add(new Edge(e.u, e.v, e.w));
				mst[e.v].add(new Edge(e.v, e.u, e.w));
				root[find(e.u)] = find(e.v);
				mstEdge[i] = true;
				cost += e.w;
				count++;
			}

			if (count == V - 1)
				break;
		}

		if (count != V - 1 || E <= V - 1)
			exit();

		dfs(1, 0);
		for (int h = 1; h <= H; h++) {
			for (int v = 1; v <= V; v++) {
				pmax[v][h] = Math.max(pmax[v][h - 1], pmax[parent[v][h - 1]][h - 1]);
				parent[v][h] = parent[parent[v][h - 1]][h - 1];
			}
		}

		long answer = Long.MAX_VALUE;
		for (int i = 0; i < E; i++) {
			if (mstEdge[i])
				continue;

			Edge e = edges[i];
			int weight = lca(e.u, e.v, e.w);
			if (weight == 0)
				continue;

			answer = Math.min(answer, cost - weight + e.w);
		}

		if (answer == Long.MAX_VALUE || answer == cost)
			exit();
		System.out.print(answer);
	}

	private static int lca(int u, int v, int w) {
		if (height[u] > height[v])
			return lca(v, u, w);

		int max = 0;

		for (int h = H; h >= 0; h--) {
			if (height[v] - height[u] >= (1 << h)) {
				max = Math.max(max, (pmax[v][h] == w) ? getMax(v, h, w) : pmax[v][h]);
				v = parent[v][h];
			}
		}
		if (u == v)
			return max;

		for (int h = H; h >= 0; h--) {
			if (parent[u][h] != parent[v][h]) {
				max = Math.max(max, (pmax[u][h] == w) ? getMax(u, h, w) : pmax[u][h]);
				max = Math.max(max, (pmax[v][h] == w) ? getMax(v, h, w) : pmax[v][h]);
				u = parent[u][h];
				v = parent[v][h];
			}
		}

		max = Math.max(max, (pmax[u][0] == w) ? max : pmax[u][0]);
		max = Math.max(max, (pmax[v][0] == w) ? max : pmax[v][0]);
		return max;
	}

	private static int getMax(int u, int h, int w) {
		if (h <= 0)
			return 0;

		int smax = Integer.MIN_VALUE;

		if (pmax[u][h - 1] == w)
			smax = Math.max(smax, getMax(u, h - 1, w));
		else
			smax = Math.max(smax, pmax[u][h - 1]);

		if (pmax[parent[u][h - 1]][h - 1] == w)
			smax = Math.max(smax, getMax(parent[u][h - 1], h - 1, w));
		else
			smax = Math.max(smax, pmax[parent[u][h - 1]][h - 1]);

		return smax;
	}

	private static void dfs(int u, int h) {
		visited[u] = true;
		height[u] = h;

		for (Edge e : mst[u]) {
			if (!visited[e.v]) {
				pmax[e.v][0] = e.w;
				parent[e.v][0] = u;
				dfs(e.v, h + 1);
			}
		}
	}

	private static int find(int v) {
		if (v == root[v])
			return v;
		return root[v] = find(root[v]);
	}

	private static void exit() {
		System.out.print(-1);
		System.exit(0);
	}

	private static class Edge {
		public int u, v, w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
}