/*
 * Author: Minho Kim (ISKU)
 * Date: July 26, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/13161
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] network;
	private static int[][] capacity, flow;
	private static Queue<Integer> q;
	private static int[] level, work;
	private static boolean[] visited;
	private static int source, sink, N, V;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		V = N + 2;

		source = 0;
		sink = N + 1;
		capacity = new int[V][V];
		flow = new int[V][V];
		network = new ArrayList[V];
		for (int i = 0; i < V; i++)
			network[i] = new ArrayList<Integer>();

		st = new StringTokenizer(br.readLine());
		for (int v = 1; v <= N; v++) {
			int camp = Integer.parseInt(st.nextToken());
			if (camp == 1) {
				network[source].add(v);
				network[v].add(source);
				capacity[source][v] = Integer.MAX_VALUE;
			}
			if (camp == 2) {
				network[v].add(sink);
				network[sink].add(v);
				capacity[v][sink] = Integer.MAX_VALUE;
			}
		}
		for (int u = 1; u <= N; u++) {
			st = new StringTokenizer(br.readLine());
			for (int v = 1; v <= N; v++) {
				if (u != v)
					network[u].add(v);
				capacity[u][v] = Integer.parseInt(st.nextToken());
			}
		}

		int mf = 0;
		int cf = 0;
		while (!bfs()) {
			work = new int[V];
			while ((cf = dfs(source, sink, Integer.MAX_VALUE)) != 0)
				mf += cf;
		}
		reachability();

		bw.write(mf + "\n");
		for (int u = 1; u <= N; u++)
			if (visited[u])
				bw.write(u + " ");
		bw.newLine();
		for (int u = 1; u <= N; u++)
			if (!visited[u])
				bw.write(u + " ");
		bw.newLine();
		bw.close();
	}

	private static boolean bfs() {
		q = new LinkedList<Integer>();
		level = new int[V];

		q.add(source);
		level[source] = 1;
		while (!q.isEmpty()) {
			int u = q.poll();

			for (int v : network[u]) {
				if (level[v] == 0 && capacity[u][v] - flow[u][v] > 0) {
					level[v] = level[u] + 1;
					q.add(v);
				}
			}
		}

		return (level[sink] == 0);
	}

	private static int dfs(int u, int dest, int cf) {
		if (u == dest)
			return cf;

		for (; work[u] < network[u].size(); work[u]++) {
			int v = network[u].get(work[u]);
			if (level[u] + 1 == level[v] && capacity[u][v] - flow[u][v] > 0) {
				int df = dfs(v, dest, Math.min(capacity[u][v] - flow[u][v], cf));
				if (df > 0) {
					flow[u][v] += df;
					flow[v][u] -= df;
					return df;
				}
			}
		}

		return 0;
	}

	private static void reachability() {
		q = new LinkedList<Integer>();
		visited = new boolean[V];

		q.add(source);
		visited[source] = true;
		while (!q.isEmpty()) {
			int u = q.poll();

			for (int v : network[u]) {
				if (!visited[v] && capacity[u][v] - flow[u][v] > 0) {
					q.add(v);
					visited[v] = true;
				}
			}
		}
	}
}