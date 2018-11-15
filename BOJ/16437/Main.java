/*
 * Author: Minho Kim (ISKU)
 * Date: November 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/16437
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] tree;
	private static long[] table;
	private static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		table = new long[N + 1];
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<Integer>();

		for (int i = 2; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String t = st.nextToken();
			long a = Long.parseLong(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			tree[i].add(p);
			tree[p].add(i);
			table[i] = ("S".equals(t)) ? a : -a;
		}

		visited = new boolean[N + 1];
		System.out.print(dfs(1));
	}

	private static long dfs(int u) {
		visited[u] = true;

		long sum = table[u];
		for (int v : tree[u])
			if (!visited[v])
				sum += dfs(v);

		return (sum > 0) ? sum : 0;
	}
}