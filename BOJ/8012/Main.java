/*
 * Author: Minho Kim (ISKU)
 * Date: July 18, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/8012
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] tree;
	private static int[][] parent;
	private static int[] height;
	private static boolean[] visited;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		H = (int) Math.ceil(Math.log(N) / Math.log(2));
		parent = new int[N + 1][H + 1];
		height = new int[N + 1];
		visited = new boolean[N + 1];
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<Integer>();

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}

		dfs(1, 0);
		for (int h = 1; h <= H; h++)
			for (int v = 1; v <= N; v++)
				parent[v][h] = parent[parent[v][h - 1]][h - 1];

		int M = Integer.parseInt(br.readLine());
		int prev = Integer.parseInt(br.readLine());
		int dist = height[prev];
		while (M-- > 1) {
			int v = Integer.parseInt(br.readLine());
			int r = lca(prev, v);
			dist += height[prev] + height[v] - 2 * height[r];
			prev = v;
		}

		System.out.print(dist);
	}

	private static int lca(int u, int v) {
		if (height[u] > height[v]) {
			int temp = u;
			u = v;
			v = temp;
		}

		for (int h = H; h >= 0; h--)
			if (height[v] - height[u] >= (1 << h))
				v = parent[v][h];
		if (u == v)
			return u;

		for (int h = H; h >= 0; h--) {
			if (parent[u][h] == parent[v][h])
				continue;
			u = parent[u][h];
			v = parent[v][h];
		}
		return parent[u][0];
	}

	private static void dfs(int u, int h) {
		visited[u] = true;
		height[u] = h;

		for (int v : tree[u]) {
			if (!visited[v]) {
				parent[v][0] = u;
				dfs(v, h + 1);
			}
		}
	}
}