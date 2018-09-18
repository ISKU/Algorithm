/*
 * Author: Minho Kim (ISKU)
 * Date: September 13, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/1396
 */

import java.util.*;
import java.io.*;

public class Main {

	private static int[] root, size, cost, count, l, r;
	private static ArrayList<Integer>[] pbs;
	private static Edge[] edges;
	private static Query[] queries;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		edges = new Edge[M];
		for (int i = 0; i < M; i++) {
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

		int Q = Integer.parseInt(br.readLine());
		queries = new Query[Q];
		l = new int[Q];
		r = new int[Q];
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			queries[i] = new Query(x, y);
			l[i] = 0;
			r[i] = M;
		}

		pbs = new ArrayList[M];
		root = new int[N + 1];
		size = new int[N + 1];
		cost = new int[N + 1];
		count = new int[N + 1];

		boolean finish = true;
		while (finish) {
			finish = false;
			for (int i = 0; i < M; i++)
				pbs[i] = new ArrayList<Integer>();
			for (int i = 1; i <= N; i++) {
				root[i] = i;
				size[i] = 1;
			}

			for (int i = 0; i < Q; i++)
				if (l[i] < r[i])
					pbs[(l[i] + r[i]) / 2].add(i);

			for (int i = 0; i < M; i++) {
				int first = find(edges[i].u);
				int second = find(edges[i].v);
				if (first != second) {
					root[first] = second;
					size[second] += size[first];
				}

				for (int j = 0; j < pbs[i].size(); j++) {
					finish = true;
					int index = pbs[i].get(j);

					first = find(queries[index].x);
					second = find(queries[index].y);
					if (first != second)
						l[index] = i + 1;
					else {
						r[index] = i;
						cost[index] = edges[i].w;
						count[index] = size[first];
					}
				}
			}
		}

		for (int i = 0; i < Q; i++) {
			if (l[i] == M)
				bw.write("-1\n");
			else {
				bw.write(String.valueOf(cost[i]));
				bw.write(" ");
				bw.write(String.valueOf(count[i]));
				bw.write("\n");
			}
		}

		bw.close();
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

	private static class Query {
		public int x, y;

		public Query(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}