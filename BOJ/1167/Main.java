/*
 * Author: Minho Kim (ISKU)
 * Date: February 05, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1167
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Edge>[] tree;
	private static boolean[] visited;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());

		tree = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			tree[u] = new ArrayList<Edge>();

			while (st.hasMoreTokens()) {
				int v = Integer.parseInt(st.nextToken());
				if (v == -1)
					break;
				int w = Integer.parseInt(st.nextToken());
				tree[u].add(new Edge(v, w));
			}
		}

		visited = new boolean[V + 1];
		Edge first = dfs(1, 0);
		visited = new boolean[V + 1];
		System.out.print(dfs(first.vertex, 0).weight);
	}

	private static Edge dfs(int vertex, int sum) {
		visited[vertex] = true;
		Edge max = new Edge(vertex, sum);

		for (Edge to : tree[vertex]) {
			if (!visited[to.vertex]) {
				Edge ret = dfs(to.vertex, sum + to.weight);
				if (max.weight < ret.weight)
					max = ret;
			}
		}

		return max;
	}

	private static class Edge {
		public int vertex;
		public int weight;

		public Edge(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}