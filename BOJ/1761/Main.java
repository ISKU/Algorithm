/*
 * Author: Minho Kim (ISKU)
 * Date: July 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1761
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Edge>[] tree;
	private static int[][] parent;
	private static int[] height, dist;
	private static boolean[] visited;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		H = (int) Math.ceil(Math.log(N) / Math.log(2));
		parent = new int[N + 1][H + 1];
		visited = new boolean[N + 1];
		height = new int[N + 1];
		dist = new int[N + 1];
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<Edge>();

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			tree[u].add(new Edge(v, w));
			tree[v].add(new Edge(u, w));
		}

		dfs(1, 0, 0);
		for (int h = 1; h <= H; h++)
			for (int v = 1; v <= N; v++)
				parent[v][h] = parent[parent[v][h - 1]][h - 1];

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			int r = lca(u, v);
			bw.write((dist[u] + dist[v] - 2 * dist[r]) + "\n");
		}

		bw.close();
	}

	private static int lca(int u, int v) {
		if (height[u] > height[v]) {
			int temp = v;
			v = u;
			u = temp;
		}

		for (int i = H; i >= 0; i--)
			if (height[v] - height[u] >= (1 << i))
				v = parent[v][i];
		if (u == v)
			return u;

		for (int i = H; i >= 0; i--) {
			if (parent[u][i] == parent[v][i])
				continue;
			u = parent[u][i];
			v = parent[v][i];
		}
		return parent[u][0];
	}

	private static void dfs(int u, int h, int d) {
		visited[u] = true;
		height[u] = h;

		for (Edge v : tree[u]) {
			if (!visited[v.vertex]) {
				parent[v.vertex][0] = u;
				dist[v.vertex] = d + v.weight;
				dfs(v.vertex, h + 1, dist[v.vertex]);
			}
		}
	}

	private static class Edge {
		public int vertex, weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}