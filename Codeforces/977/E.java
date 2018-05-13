/*
 * Author: Minho Kim (ISKU)
 * Date: May 12, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * http://codeforces.com/problemset/problem/977/E
 */

import java.util.*;
import java.io.*;

public class E {

	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	private static int answer;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Integer>();

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			if (!visited[i] && dfs(i))
				answer++;

		bw.write(String.valueOf(answer));
		bw.close();
	}

	private static boolean dfs(int u) {
		visited[u] = true;

		boolean check = (graph[u].size() == 2) ? true : false;
		for (int v : graph[u])
			if (!visited[v])
				check &= dfs(v);

		return check;
	}
}