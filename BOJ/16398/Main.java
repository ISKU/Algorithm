/*
 * Author: Minho Kim (ISKU)
 * Date: November 11, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16398
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] root;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		root = new int[N];
		Queue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});

		for (int u = 0; u < N; u++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			root[u] = u;

			for (int v = 0; v < N; v++) {
				int w = Integer.parseInt(st.nextToken());
				if (u == v)
					continue;
				pq.add(new Edge(u, v, w));
			}
		}

		long cost = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();

			int first = find(e.u);
			int second = find(e.v);
			if (first != second) {
				root[first] = second;
				cost += e.w;
			}
		}

		System.out.print(cost);
	}

	private static int find(int v) {
		if (root[v] == v)
			return v;
		return root[v] = find(root[v]);
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