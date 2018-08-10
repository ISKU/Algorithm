/*
 * Author: Minho Kim (ISKU)
 * Date: August 9, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/10451
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] graph;
	private static boolean[] visited, finished;
	private static int cycle;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++)
				graph[i] = new ArrayList<Integer>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int u = 1; u <= N; u++)
				graph[u].add(Integer.parseInt(st.nextToken()));

			visited = new boolean[N + 1];
			finished = new boolean[N + 1];
			cycle = 0;
			for (int u = 1; u <= N; u++)
				if (!visited[u])
					dfs(u);

			bw.write(cycle + "\n");
		}

		bw.close();
	}

	private static void dfs(int u) {
		visited[u] = true;

		for (int v : graph[u]) {
			if (!visited[v])
				dfs(v);
			if (!finished[v] && visited[v])
				cycle++;
		}

		finished[u] = true;
	}
}