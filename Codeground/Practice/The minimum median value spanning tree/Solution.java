/* 
 * Author: Minho Kim (ISKU)
 * Date: January 10, 2018
 * E-mail: minho1a@hanmail.net
 * 
 * https://github.com/ISKU/Algorithm
 * https://www.codeground.org/
 */

import java.util.*;
import java.io.*;

public class Solution {

	private static ArrayList<Edge> edges;
	private static ArrayList<Integer> costs;
	private static int[] parent;
	private static int V, E;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parent = new int[V + 1];
			edges = new ArrayList<Edge>();
			costs = new ArrayList<Integer>();

			for (int i = 1; i <= V; i++)
				parent[i] = i;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				edges.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			Collections.sort(edges);
			for (Edge edge : edges) {
				if (find(edge.v) != find(edge.w)) {
					parent[find(edge.v)] = parent[edge.w];
					costs.add(edge.weight);
				}
			}

			Collections.sort(costs);
			System.out.printf("Case #%d\n%d\n", tc, costs.get(costs.size() / 2));
		}

	}

	private static int find(int v) {
		if (parent[v] != v)
			return parent[v] = find(parent[v]);
		return v;
	}

	private static class Edge implements Comparable<Edge> {
		public int v, w;
		public int weight;

		public Edge(int v, int w, int weight) {
			this.v = v;
			this.w = w;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}