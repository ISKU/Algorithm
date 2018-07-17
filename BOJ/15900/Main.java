/*
 * Author: Minho Kim (ISKU)
 * Date: July 15, 2018
 * E-mail: minho.kim093@gmail.com
 *
 * https://github.com/ISKU/Algorithm
 * https://www.acmicpc.net/problem/15900
 */

import java.util.*;
import java.io.*;

public class Main {

	private static ArrayList<Integer>[] tree;
	private static boolean[] visited;
	private static int sum;

	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			tree[i] = new ArrayList<Integer>();

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}

		visited = new boolean[N + 1];
		dfs(1, 0);

		System.out.print((sum % 2 == 1) ? "Yes" : "No");
	}

	private static void dfs(int u, int count) {
		visited[u] = true;

		for (int v : tree[u])
			if (!visited[v])
				dfs(v, count + 1);

		if (u != 1 && tree[u].size() == 1)
			sum += count;
	}
}