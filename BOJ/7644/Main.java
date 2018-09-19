/*
 * Author: Minho Kim (ISKU)
 * Date: September 19, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/7644
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Edge>[] tree;
	private static int N, answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			tree = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				tree[i] = new ArrayList<Edge>();
			for (int i = 1; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				tree[u].add(new Edge(u, v, w));
				tree[v].add(new Edge(v, u, w));
			}

			int first = bfs(1);
			int second = bfs(first);
			initDiameter(first, second);
			initDiameter(second, first);

			bfs(first);
			bw.write(String.valueOf(answer));
			bw.write("\n");
		}

		bw.close();
	}

	private static void initDiameter(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		q.add(start);
		visited[start] = true;

		Edge[] path = new Edge[N + 1];
		while (!q.isEmpty()) {
			int u = q.poll();

			if (u == end) {
				for (Edge e = path[end]; e != null; e = path[e.u])
					e.w = 0;
			}

			for (Edge v : tree[u]) {
				if (!visited[v.v]) {
					visited[v.v] = true;
					path[v.v] = v;
					q.add(v.v);
				}
			}
		}
	}

	private static int bfs(int start) {
		Queue<Edge> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		q.add(new Edge(start, start, 0));
		visited[start] = true;

		int vertex = start;
		int weight = 0;
		answer = 0;
		while (!q.isEmpty()) {
			Edge u = q.poll();

			if (u.w > weight) {
				weight = u.w;
				vertex = u.v;
				answer = weight;
			}

			for (Edge v : tree[u.v]) {
				if (!visited[v.v]) {
					visited[v.v] = true;
					q.add(new Edge(u.v, v.v, u.w + v.w));
				}
			}
		}

		return vertex;
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