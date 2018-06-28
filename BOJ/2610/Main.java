/*
 * Author: Minho Kim (ISKU)
 * Date: June 28, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/2610
 */

import java.util.*;
import java.io.*;

public class Main {

	public static final int INF = 100000000;

	private static ArrayList<ArrayList<Integer>> committees;
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<Integer>();

		int[][] dist = new int[N][N];
		for (int u = 0; u < N; u++) {
			Arrays.fill(dist[u], INF);
			dist[u][u] = 0;
		}

		while (M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			graph[u].add(v);
			graph[v].add(u);
			dist[u][v] = 1;
			dist[v][u] = 1;
		}

		for (int k = 0; k < N; k++)
			for (int u = 0; u < N; u++)
				for (int v = 0; v < N; v++)
					dist[u][v] = Math.min(dist[u][v], dist[u][k] + dist[k][v]);

		committees = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				ArrayList<Integer> group = new ArrayList<>();
				dfs(i, group);
				committees.add(group);
			}
		}

		ArrayList<Integer> reps = new ArrayList<>();
		for (ArrayList<Integer> group : committees) {
			int max = INF;
			int rep = group.get(0);

			for (int u : group) {
				int cost = 0;
				for (int v : group)
					cost = Math.max(cost, dist[u][v]);

				if (cost < max) {
					rep = u;
					max = cost;
				}
			}

			reps.add(rep);
		}
		Collections.sort(reps);

		bw.write(committees.size() + "\n");
		for (int rep : reps)
			bw.write((rep + 1) + "\n");

		bw.close();
	}

	private static void dfs(int u, ArrayList<Integer> group) {
		visited[u] = true;
		group.add(u);

		for (int v : graph[u])
			if (!visited[v])
				dfs(v, group);
	}
}