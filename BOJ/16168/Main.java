/*
 * Author: Minho Kim (ISKU)
 * Date: September 29, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16168
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

		int count = 0;
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}

		int odd = 0;
		int even = 0;
		for (int i = 1; i <= N; i++) {
			if (graph[i].size() % 2 == 0)
				even++;
			else
				odd++;
		}

		if (count >= 2)
			System.out.print("NO");
		else if (even == N)
			System.out.print("YES");
		else if (odd == 2)
			System.out.print("YES");
		else
			System.out.print("NO");
	}

	private static void dfs(int u) {
		visited[u] = true;

		for (int v : graph[u])
			if (!visited[v])
				dfs(v);
	}
}