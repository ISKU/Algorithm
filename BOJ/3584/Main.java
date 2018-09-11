/*
 * Author: Minho Kim (ISKU)
 * Date: September 11, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/3584
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] tree;
	private static int[][] parent;
	private static int[] height, in;
	private static boolean[] visited;
	private static int H;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			in = new int[N + 1];
			tree = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				tree[i] = new ArrayList<Integer>();
			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				tree[u].add(v);
				tree[v].add(u);
				in[v]++;
			}

			int root = 1;
			while (in[root] != 0)
				root++;

			H = (int) Math.ceil(Math.log(N) / Math.log(2));
			visited = new boolean[N + 1];
			height = new int[N + 1];
			parent = new int[N + 1][H + 1];
			dfs(root, 0);
			for (int h = 1; h <= H; h++)
				for (int v = 1; v <= N; v++)
					parent[v][h] = parent[parent[v][h - 1]][h - 1];

			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			bw.write(lca(u, v) + "\n");
		}

		bw.close();
	}

	private static int lca(int u, int v) {
		if (height[u] > height[v])
			return lca(v, u);

		for (int h = H; h >= 0; h--)
			if (height[v] - height[u] >= (1 << h))
				v = parent[v][h];

		if (u == v)
			return u;

		for (int h = H; h >= 0; h--) {
			if (parent[u][h] != parent[v][h]) {
				u = parent[u][h];
				v = parent[v][h];
			}
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