/*
 * Author: Minho Kim (ISKU)
 * Date: May 24, 2019
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/17220
 */

import java.io.*;
import java.util.*;

public class Main {

	private static List<Integer>[] graph;
	private static boolean[] visited, out;
	private static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		out = new boolean[26];
		visited = new boolean[26];
		graph = new ArrayList[26];
		for (int u = 0; u < 26; u++)
			graph[u] = new ArrayList<Integer>();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = st.nextToken().charAt(0) - 'A';
			int v = st.nextToken().charAt(0) - 'A';
			graph[u].add(v);
			out[v] = true;
		}

		st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());
		while (Q-- > 0) {
			int u = st.nextToken().charAt(0) - 'A';
			visited[u] = true;
		}

		for (int u = 0; u < 26; u++)
			if (!out[u] && graph[u].size() != 0 && !visited[u])
				dfs(u);
		System.out.print(count);
	}

	private static void dfs(int u) {
		visited[u] = true;

		for (int v : graph[u]) {
			if (!visited[v]) {
				dfs(v);
				count++;
			}
		}
	}
}